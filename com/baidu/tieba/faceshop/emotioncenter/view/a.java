package com.baidu.tieba.faceshop.emotioncenter.view;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.a.c;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener, c {
    private BdTypeListView gAY;
    private NoNetworkView gCe;
    private PbListView gCf;
    private g gLj;
    private View iXL;
    private RelativeLayout iXM;
    private TextView iXN;
    private ImageView iXO;
    private com.baidu.tieba.faceshop.emotioncenter.a iXP;
    private EmotionCenterForumView iXQ;
    private EmotionCenterChangeView iXR;
    private com.baidu.tieba.faceshop.emotioncenter.adapter.a iXS;
    private EmotionCenterData iXT;
    private com.baidu.tieba.faceshop.emotioncenter.a.a iXU;
    private LinearLayout iXV;
    private ImageView iXW;
    private TextView iXX;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;
    private Animation iXH = null;
    private boolean iXY = true;
    private int iXZ = 0;
    private String iYa = "";

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mRootView = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_emotion_center_layout, (ViewGroup) null);
        this.gCe = new NoNetworkView(tbPageContext.getPageActivity());
        this.gCe.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        if (j.isNetWorkAvailable()) {
            this.gCe.setVisibility(8);
        }
        this.mRootView.addView(this.gCe);
        this.gAY = (BdTypeListView) this.mRootView.findViewById(R.id.emotion_center_list);
        this.gAY.setDivider(null);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.gAY.setPullRefresh(this.mPullView);
        this.gCf = new PbListView(tbPageContext.getPageActivity());
        this.gCf.createView();
        this.iXP = new com.baidu.tieba.faceshop.emotioncenter.a(this.mPageContext);
        this.iXP.getView().setVisibility(8);
        this.iXQ = new EmotionCenterForumView(this.mPageContext);
        this.iXQ.setVisibility(8);
        this.iXS = new com.baidu.tieba.faceshop.emotioncenter.adapter.a(this.mPageContext, this.gAY);
        this.iXR = new EmotionCenterChangeView(this.mPageContext);
        this.iXR.setVisibility(8);
        this.gAY.addHeaderView(this.iXP.getView());
        this.gAY.addHeaderView(this.iXQ);
        this.gAY.addHeaderView(this.iXR);
        this.iXL = this.mRootView.findViewById(R.id.emotion_add_layout);
        this.iXM = (RelativeLayout) this.mRootView.findViewById(R.id.emotion_add_layout);
        this.iXN = (TextView) this.mRootView.findViewById(R.id.add_emotion_tv);
        this.iXO = (ImageView) this.mRootView.findViewById(R.id.icon_add);
        this.iXL.setOnClickListener(this);
        this.iXV = (LinearLayout) this.mRootView.findViewById(R.id.emotion_upload_status);
        this.iXV.setClickable(false);
        this.iXV.setOnClickListener(this);
        this.iXV.setVisibility(8);
        this.iXW = (ImageView) this.mRootView.findViewById(R.id.uploading_status_img);
        this.iXX = (TextView) this.mRootView.findViewById(R.id.add_emotion_upload_status);
        showLoadingView();
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.gLj = new g(this.mPageContext.getPageActivity());
            this.gLj.attachView(this.mRootView, false);
            this.gLj.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this.mRootView);
            this.gLj = null;
        }
    }

    public ViewGroup getView() {
        return this.mRootView;
    }

    public View cCG() {
        return this.gCe;
    }

    public void a(EmotionPackageData emotionPackageData) {
        if (emotionPackageData != null) {
            if (this.iXR != null) {
                this.iXR.a(emotionPackageData);
            }
            if (this.iXS != null) {
                this.iXS.a(emotionPackageData);
            }
        }
    }

    public void d(EmotionCenterData emotionCenterData) {
        if (emotionCenterData != null) {
            hideLoadingView();
            if (x.isEmpty(this.iXR.getDataList())) {
                this.iXR.cCD();
                this.iXR.setVisibility(0);
            }
            this.iXT = emotionCenterData;
            if (this.iXY) {
                this.iXZ = b.toInt(emotionCenterData.is_bazhu, 0);
                this.iYa = emotionCenterData.bazhu_message;
                this.iXY = false;
            }
            if (emotionCenterData.banner != null) {
                this.iXP.getView().setVisibility(0);
                this.iXP.l(this.mPageContext.getUniqueId());
                this.iXP.a(new com.baidu.tieba.faceshop.emotioncenter.data.c(emotionCenterData.banner));
                this.iXP.byV();
            }
            if (emotionCenterData.forum != null) {
                this.iXQ.setVisibility(0);
                this.iXQ.setData(emotionCenterData.forum);
            }
            if (!x.isEmpty(emotionCenterData.package_list)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.tieba.faceshop.emotioncenter.data.a());
                for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                    com.baidu.tieba.faceshop.emotioncenter.data.b bVar = new com.baidu.tieba.faceshop.emotioncenter.data.b();
                    bVar.iXh = emotionPackageData;
                    arrayList.add(bVar);
                }
                this.iXS.setDatas(arrayList);
            }
            this.iXS.notifyDataSetChanged();
        }
    }

    public void e(EmotionCenterData emotionCenterData) {
        if (emotionCenterData != null) {
            this.iXT = emotionCenterData;
            if (!x.isEmpty(this.iXT.package_list)) {
                ArrayList arrayList = new ArrayList();
                for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                    com.baidu.tieba.faceshop.emotioncenter.data.b bVar = new com.baidu.tieba.faceshop.emotioncenter.data.b();
                    bVar.iXh = emotionPackageData;
                    arrayList.add(bVar);
                }
                this.iXS.cJ(arrayList);
            }
            this.iXS.notifyDataSetChanged();
        }
    }

    public void cCH() {
        if (this.iXU != null) {
            this.iXU.dismiss();
        }
        endAnimation();
        this.iXV.setVisibility(8);
        this.iXL.setVisibility(0);
    }

    public void cCI() {
        if (this.iXU != null) {
            this.iXU.dismiss();
        }
        startAnimation();
        this.iXV.setVisibility(0);
        this.iXL.setVisibility(8);
        ao.setBackgroundColor(this.iXV, R.color.CAM_X0201);
        ao.setImageResource(this.iXW, R.drawable.emotion_uploading_bar_refresh);
        ao.setViewTextColor(this.iXX, R.color.CAM_X0302);
        this.iXX.setText(R.string.emotion_uploading);
        this.iXV.setClickable(false);
    }

    public void cCJ() {
        if (this.iXU != null) {
            this.iXU.dismiss();
        }
        endAnimation();
        this.iXV.setVisibility(0);
        this.iXL.setVisibility(8);
        ao.setBackgroundColor(this.iXV, R.color.CAM_X0201);
        ao.setImageResource(this.iXW, R.drawable.emotion_update_fail);
        ao.setViewTextColor(this.iXX, R.color.common_color_10037);
        this.iXX.setText(R.string.emotion_center_upload_failed);
        this.iXV.setClickable(true);
    }

    private Animation getClickRotateAnimation() {
        if (this.iXH == null) {
            this.iXH = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.refresh_rotate);
            this.iXH.setInterpolator(new LinearInterpolator());
            this.iXH.setFillAfter(true);
        }
        return this.iXH;
    }

    public void startAnimation() {
        if (this.iXW != null) {
            this.iXW.startAnimation(getClickRotateAnimation());
        }
    }

    public void endAnimation() {
        if (this.iXW != null) {
            this.iXW.clearAnimation();
        }
    }

    public int cCK() {
        return this.iXZ;
    }

    public void completePullRefresh() {
        this.gAY.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bUE() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gAY.setNextPage(this.gCf);
            }
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gCf.endLoadData();
        }
    }

    public void bUF() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gAY.setNextPage(this.gCf);
            }
            this.gCf.showLoadingViewWithoutEmptyView();
            this.gCf.startLoadData();
        }
    }

    public void bVG() {
        if (this.gCf != null) {
            this.gCf.endLoadData();
        }
        this.gAY.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.gAY.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gCf.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.iXS.notifyDataSetChanged();
        ao.setBackgroundColor(this.iXM, R.color.CAM_X0201);
        this.gAY.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.gCe.onChangeSkinType(this.mPageContext, i);
        if (this.iXQ != null) {
            this.iXQ.onChangeSkin(i);
        }
        if (this.iXM != null) {
            ao.setBackgroundColor(this.iXM, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iXN != null) {
            ao.setViewTextColor(this.iXN, R.color.CAM_X0302, i);
        }
        if (this.iXO != null) {
            ao.setImageResource(this.iXO, R.drawable.emotion_bar_add_icon);
        }
        if (this.iXV != null) {
            ao.setBackgroundColor(this.iXM, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iXW != null) {
            ao.setImageResource(this.iXW, R.drawable.emotion_uploading_bar_refresh);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iXL) {
            if (this.iXT != null) {
                if (this.iXZ != 0) {
                    if (this.iXU == null) {
                        this.iXU = new com.baidu.tieba.faceshop.emotioncenter.a.a(this.mPageContext.getPageActivity(), this.iXZ);
                        this.iXU.a(this);
                    }
                    this.iXU.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
                    Rect rect = new Rect();
                    this.mPageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.iXU.showAtLocation(this.mRootView, 81, 0, this.mPageContext.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                    return;
                }
                cCy();
            }
        } else if (view == this.iXV) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), this.iXZ == 1, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
    public void cCx() {
        if (this.iXZ == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), true, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        } else if (!TextUtils.isEmpty(this.iYa)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.Bo(this.iYa);
            aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.faceshop.emotioncenter.view.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.faceshop.emotioncenter.view.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mPageContext).btY();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
    public void cCy() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
    }

    public EmotionCenterChangeView cCL() {
        return this.iXR;
    }
}
