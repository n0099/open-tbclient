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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
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
    private NoNetworkView gAh;
    private PbListView gAi;
    private g gJn;
    private BdTypeListView gzb;
    private View iYL;
    private RelativeLayout iYM;
    private TextView iYN;
    private ImageView iYO;
    private com.baidu.tieba.faceshop.emotioncenter.a iYP;
    private EmotionCenterForumView iYQ;
    private EmotionCenterChangeView iYR;
    private com.baidu.tieba.faceshop.emotioncenter.adapter.a iYS;
    private EmotionCenterData iYT;
    private com.baidu.tieba.faceshop.emotioncenter.a.a iYU;
    private LinearLayout iYV;
    private ImageView iYW;
    private TextView iYX;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;
    private Animation iYH = null;
    private boolean iYY = true;
    private int iYZ = 0;
    private String iZa = "";

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mRootView = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_emotion_center_layout, (ViewGroup) null);
        this.gAh = new NoNetworkView(tbPageContext.getPageActivity());
        this.gAh.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        if (j.isNetWorkAvailable()) {
            this.gAh.setVisibility(8);
        }
        this.mRootView.addView(this.gAh);
        this.gzb = (BdTypeListView) this.mRootView.findViewById(R.id.emotion_center_list);
        this.gzb.setDivider(null);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.gzb.setPullRefresh(this.mPullView);
        this.gAi = new PbListView(tbPageContext.getPageActivity());
        this.gAi.createView();
        this.iYP = new com.baidu.tieba.faceshop.emotioncenter.a(this.mPageContext);
        this.iYP.getView().setVisibility(8);
        this.iYQ = new EmotionCenterForumView(this.mPageContext);
        this.iYQ.setVisibility(8);
        this.iYS = new com.baidu.tieba.faceshop.emotioncenter.adapter.a(this.mPageContext, this.gzb);
        this.iYR = new EmotionCenterChangeView(this.mPageContext);
        this.iYR.setVisibility(8);
        this.gzb.addHeaderView(this.iYP.getView());
        this.gzb.addHeaderView(this.iYQ);
        this.gzb.addHeaderView(this.iYR);
        this.iYL = this.mRootView.findViewById(R.id.emotion_add_layout);
        this.iYM = (RelativeLayout) this.mRootView.findViewById(R.id.emotion_add_layout);
        this.iYN = (TextView) this.mRootView.findViewById(R.id.add_emotion_tv);
        this.iYO = (ImageView) this.mRootView.findViewById(R.id.icon_add);
        this.iYL.setOnClickListener(this);
        this.iYV = (LinearLayout) this.mRootView.findViewById(R.id.emotion_upload_status);
        this.iYV.setClickable(false);
        this.iYV.setOnClickListener(this);
        this.iYV.setVisibility(8);
        this.iYW = (ImageView) this.mRootView.findViewById(R.id.uploading_status_img);
        this.iYX = (TextView) this.mRootView.findViewById(R.id.add_emotion_upload_status);
        showLoadingView();
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.gJn = new g(this.mPageContext.getPageActivity());
            this.gJn.attachView(this.mRootView, false);
            this.gJn.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this.mRootView);
            this.gJn = null;
        }
    }

    public ViewGroup getView() {
        return this.mRootView;
    }

    public View czZ() {
        return this.gAh;
    }

    public void a(EmotionPackageData emotionPackageData) {
        if (emotionPackageData != null) {
            if (this.iYR != null) {
                this.iYR.a(emotionPackageData);
            }
            if (this.iYS != null) {
                this.iYS.a(emotionPackageData);
            }
        }
    }

    public void d(EmotionCenterData emotionCenterData) {
        if (emotionCenterData != null) {
            hideLoadingView();
            if (y.isEmpty(this.iYR.getDataList())) {
                this.iYR.czW();
                this.iYR.setVisibility(0);
            }
            this.iYT = emotionCenterData;
            if (this.iYY) {
                this.iYZ = b.toInt(emotionCenterData.is_bazhu, 0);
                this.iZa = emotionCenterData.bazhu_message;
                this.iYY = false;
            }
            if (emotionCenterData.banner != null) {
                this.iYP.getView().setVisibility(0);
                this.iYP.l(this.mPageContext.getUniqueId());
                this.iYP.a(new com.baidu.tieba.faceshop.emotioncenter.data.c(emotionCenterData.banner));
                this.iYP.bvv();
            }
            if (emotionCenterData.forum != null) {
                this.iYQ.setVisibility(0);
                this.iYQ.setData(emotionCenterData.forum);
            }
            if (!y.isEmpty(emotionCenterData.package_list)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.tieba.faceshop.emotioncenter.data.a());
                for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                    com.baidu.tieba.faceshop.emotioncenter.data.b bVar = new com.baidu.tieba.faceshop.emotioncenter.data.b();
                    bVar.iYh = emotionPackageData;
                    arrayList.add(bVar);
                }
                this.iYS.setDatas(arrayList);
            }
            this.iYS.notifyDataSetChanged();
        }
    }

    public void e(EmotionCenterData emotionCenterData) {
        if (emotionCenterData != null) {
            this.iYT = emotionCenterData;
            if (!y.isEmpty(this.iYT.package_list)) {
                ArrayList arrayList = new ArrayList();
                for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                    com.baidu.tieba.faceshop.emotioncenter.data.b bVar = new com.baidu.tieba.faceshop.emotioncenter.data.b();
                    bVar.iYh = emotionPackageData;
                    arrayList.add(bVar);
                }
                this.iYS.cE(arrayList);
            }
            this.iYS.notifyDataSetChanged();
        }
    }

    public void cAa() {
        if (this.iYU != null) {
            this.iYU.dismiss();
        }
        endAnimation();
        this.iYV.setVisibility(8);
        this.iYL.setVisibility(0);
    }

    public void cAb() {
        if (this.iYU != null) {
            this.iYU.dismiss();
        }
        startAnimation();
        this.iYV.setVisibility(0);
        this.iYL.setVisibility(8);
        ap.setBackgroundColor(this.iYV, R.color.CAM_X0201);
        ap.setImageResource(this.iYW, R.drawable.emotion_uploading_bar_refresh);
        ap.setViewTextColor(this.iYX, R.color.CAM_X0302);
        this.iYX.setText(R.string.emotion_uploading);
        this.iYV.setClickable(false);
    }

    public void cAc() {
        if (this.iYU != null) {
            this.iYU.dismiss();
        }
        endAnimation();
        this.iYV.setVisibility(0);
        this.iYL.setVisibility(8);
        ap.setBackgroundColor(this.iYV, R.color.CAM_X0201);
        ap.setImageResource(this.iYW, R.drawable.emotion_update_fail);
        ap.setViewTextColor(this.iYX, R.color.common_color_10037);
        this.iYX.setText(R.string.emotion_center_upload_failed);
        this.iYV.setClickable(true);
    }

    private Animation getClickRotateAnimation() {
        if (this.iYH == null) {
            this.iYH = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.refresh_rotate);
            this.iYH.setInterpolator(new LinearInterpolator());
            this.iYH.setFillAfter(true);
        }
        return this.iYH;
    }

    public void startAnimation() {
        if (this.iYW != null) {
            this.iYW.startAnimation(getClickRotateAnimation());
        }
    }

    public void endAnimation() {
        if (this.iYW != null) {
            this.iYW.clearAnimation();
        }
    }

    public int cAd() {
        return this.iYZ;
    }

    public void completePullRefresh() {
        this.gzb.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bRq() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.gzb.setNextPage(this.gAi);
            }
            this.gAi.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gAi.endLoadData();
        }
    }

    public void bRr() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.gzb.setNextPage(this.gAi);
            }
            this.gAi.showLoadingViewWithoutEmptyView();
            this.gAi.startLoadData();
        }
    }

    public void bSr() {
        if (this.gAi != null) {
            this.gAi.endLoadData();
        }
        this.gzb.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.gzb.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gAi.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.iYS.notifyDataSetChanged();
        ap.setBackgroundColor(this.iYM, R.color.CAM_X0201);
        this.gzb.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.gAh.onChangeSkinType(this.mPageContext, i);
        if (this.iYQ != null) {
            this.iYQ.onChangeSkin(i);
        }
        if (this.iYM != null) {
            ap.setBackgroundColor(this.iYM, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iYN != null) {
            ap.setViewTextColor(this.iYN, R.color.CAM_X0302, i);
        }
        if (this.iYO != null) {
            ap.setImageResource(this.iYO, R.drawable.emotion_bar_add_icon);
        }
        if (this.iYV != null) {
            ap.setBackgroundColor(this.iYM, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iYW != null) {
            ap.setImageResource(this.iYW, R.drawable.emotion_uploading_bar_refresh);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iYL) {
            if (this.iYT != null) {
                if (this.iYZ != 0) {
                    if (this.iYU == null) {
                        this.iYU = new com.baidu.tieba.faceshop.emotioncenter.a.a(this.mPageContext.getPageActivity(), this.iYZ);
                        this.iYU.a(this);
                    }
                    this.iYU.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
                    Rect rect = new Rect();
                    this.mPageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.iYU.showAtLocation(this.mRootView, 81, 0, this.mPageContext.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                    return;
                }
                czR();
            }
        } else if (view == this.iYV) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), this.iYZ == 1, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
    public void czQ() {
        if (this.iYZ == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), true, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        } else if (!TextUtils.isEmpty(this.iZa)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.Au(this.iZa);
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
            aVar.b(this.mPageContext).bqx();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
    public void czR() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
    }

    public EmotionCenterChangeView cAe() {
        return this.iYR;
    }
}
