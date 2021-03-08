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
/* loaded from: classes8.dex */
public class a implements View.OnClickListener, c {
    private BdTypeListView gAY;
    private NoNetworkView gCe;
    private PbListView gCf;
    private g gLk;
    private View jaI;
    private RelativeLayout jaJ;
    private TextView jaK;
    private ImageView jaL;
    private com.baidu.tieba.faceshop.emotioncenter.a jaM;
    private EmotionCenterForumView jaN;
    private EmotionCenterChangeView jaO;
    private com.baidu.tieba.faceshop.emotioncenter.adapter.a jaP;
    private EmotionCenterData jaQ;
    private com.baidu.tieba.faceshop.emotioncenter.a.a jaR;
    private LinearLayout jaS;
    private ImageView jaT;
    private TextView jaU;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;
    private Animation jaE = null;
    private boolean jaV = true;
    private int jaW = 0;
    private String jaX = "";

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
        this.jaM = new com.baidu.tieba.faceshop.emotioncenter.a(this.mPageContext);
        this.jaM.getView().setVisibility(8);
        this.jaN = new EmotionCenterForumView(this.mPageContext);
        this.jaN.setVisibility(8);
        this.jaP = new com.baidu.tieba.faceshop.emotioncenter.adapter.a(this.mPageContext, this.gAY);
        this.jaO = new EmotionCenterChangeView(this.mPageContext);
        this.jaO.setVisibility(8);
        this.gAY.addHeaderView(this.jaM.getView());
        this.gAY.addHeaderView(this.jaN);
        this.gAY.addHeaderView(this.jaO);
        this.jaI = this.mRootView.findViewById(R.id.emotion_add_layout);
        this.jaJ = (RelativeLayout) this.mRootView.findViewById(R.id.emotion_add_layout);
        this.jaK = (TextView) this.mRootView.findViewById(R.id.add_emotion_tv);
        this.jaL = (ImageView) this.mRootView.findViewById(R.id.icon_add);
        this.jaI.setOnClickListener(this);
        this.jaS = (LinearLayout) this.mRootView.findViewById(R.id.emotion_upload_status);
        this.jaS.setClickable(false);
        this.jaS.setOnClickListener(this);
        this.jaS.setVisibility(8);
        this.jaT = (ImageView) this.mRootView.findViewById(R.id.uploading_status_img);
        this.jaU = (TextView) this.mRootView.findViewById(R.id.add_emotion_upload_status);
        showLoadingView();
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.gLk = new g(this.mPageContext.getPageActivity());
            this.gLk.attachView(this.mRootView, false);
            this.gLk.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this.mRootView);
            this.gLk = null;
        }
    }

    public ViewGroup getView() {
        return this.mRootView;
    }

    public View cAm() {
        return this.gCe;
    }

    public void a(EmotionPackageData emotionPackageData) {
        if (emotionPackageData != null) {
            if (this.jaO != null) {
                this.jaO.a(emotionPackageData);
            }
            if (this.jaP != null) {
                this.jaP.a(emotionPackageData);
            }
        }
    }

    public void d(EmotionCenterData emotionCenterData) {
        if (emotionCenterData != null) {
            hideLoadingView();
            if (y.isEmpty(this.jaO.getDataList())) {
                this.jaO.cAj();
                this.jaO.setVisibility(0);
            }
            this.jaQ = emotionCenterData;
            if (this.jaV) {
                this.jaW = b.toInt(emotionCenterData.is_bazhu, 0);
                this.jaX = emotionCenterData.bazhu_message;
                this.jaV = false;
            }
            if (emotionCenterData.banner != null) {
                this.jaM.getView().setVisibility(0);
                this.jaM.l(this.mPageContext.getUniqueId());
                this.jaM.a(new com.baidu.tieba.faceshop.emotioncenter.data.c(emotionCenterData.banner));
                this.jaM.bvy();
            }
            if (emotionCenterData.forum != null) {
                this.jaN.setVisibility(0);
                this.jaN.setData(emotionCenterData.forum);
            }
            if (!y.isEmpty(emotionCenterData.package_list)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.tieba.faceshop.emotioncenter.data.a());
                for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                    com.baidu.tieba.faceshop.emotioncenter.data.b bVar = new com.baidu.tieba.faceshop.emotioncenter.data.b();
                    bVar.jae = emotionPackageData;
                    arrayList.add(bVar);
                }
                this.jaP.setDatas(arrayList);
            }
            this.jaP.notifyDataSetChanged();
        }
    }

    public void e(EmotionCenterData emotionCenterData) {
        if (emotionCenterData != null) {
            this.jaQ = emotionCenterData;
            if (!y.isEmpty(this.jaQ.package_list)) {
                ArrayList arrayList = new ArrayList();
                for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                    com.baidu.tieba.faceshop.emotioncenter.data.b bVar = new com.baidu.tieba.faceshop.emotioncenter.data.b();
                    bVar.jae = emotionPackageData;
                    arrayList.add(bVar);
                }
                this.jaP.cE(arrayList);
            }
            this.jaP.notifyDataSetChanged();
        }
    }

    public void cAn() {
        if (this.jaR != null) {
            this.jaR.dismiss();
        }
        endAnimation();
        this.jaS.setVisibility(8);
        this.jaI.setVisibility(0);
    }

    public void cAo() {
        if (this.jaR != null) {
            this.jaR.dismiss();
        }
        startAnimation();
        this.jaS.setVisibility(0);
        this.jaI.setVisibility(8);
        ap.setBackgroundColor(this.jaS, R.color.CAM_X0201);
        ap.setImageResource(this.jaT, R.drawable.emotion_uploading_bar_refresh);
        ap.setViewTextColor(this.jaU, R.color.CAM_X0302);
        this.jaU.setText(R.string.emotion_uploading);
        this.jaS.setClickable(false);
    }

    public void cAp() {
        if (this.jaR != null) {
            this.jaR.dismiss();
        }
        endAnimation();
        this.jaS.setVisibility(0);
        this.jaI.setVisibility(8);
        ap.setBackgroundColor(this.jaS, R.color.CAM_X0201);
        ap.setImageResource(this.jaT, R.drawable.emotion_update_fail);
        ap.setViewTextColor(this.jaU, R.color.common_color_10037);
        this.jaU.setText(R.string.emotion_center_upload_failed);
        this.jaS.setClickable(true);
    }

    private Animation getClickRotateAnimation() {
        if (this.jaE == null) {
            this.jaE = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.refresh_rotate);
            this.jaE.setInterpolator(new LinearInterpolator());
            this.jaE.setFillAfter(true);
        }
        return this.jaE;
    }

    public void startAnimation() {
        if (this.jaT != null) {
            this.jaT.startAnimation(getClickRotateAnimation());
        }
    }

    public void endAnimation() {
        if (this.jaT != null) {
            this.jaT.clearAnimation();
        }
    }

    public int cAq() {
        return this.jaW;
    }

    public void completePullRefresh() {
        this.gAY.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bRD() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gAY.setNextPage(this.gCf);
            }
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gCf.endLoadData();
        }
    }

    public void bRE() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.gAY.setNextPage(this.gCf);
            }
            this.gCf.showLoadingViewWithoutEmptyView();
            this.gCf.startLoadData();
        }
    }

    public void bSE() {
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
        this.jaP.notifyDataSetChanged();
        ap.setBackgroundColor(this.jaJ, R.color.CAM_X0201);
        this.gAY.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.gCe.onChangeSkinType(this.mPageContext, i);
        if (this.jaN != null) {
            this.jaN.onChangeSkin(i);
        }
        if (this.jaJ != null) {
            ap.setBackgroundColor(this.jaJ, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.jaK != null) {
            ap.setViewTextColor(this.jaK, R.color.CAM_X0302, i);
        }
        if (this.jaL != null) {
            ap.setImageResource(this.jaL, R.drawable.emotion_bar_add_icon);
        }
        if (this.jaS != null) {
            ap.setBackgroundColor(this.jaJ, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.jaT != null) {
            ap.setImageResource(this.jaT, R.drawable.emotion_uploading_bar_refresh);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jaI) {
            if (this.jaQ != null) {
                if (this.jaW != 0) {
                    if (this.jaR == null) {
                        this.jaR = new com.baidu.tieba.faceshop.emotioncenter.a.a(this.mPageContext.getPageActivity(), this.jaW);
                        this.jaR.a(this);
                    }
                    this.jaR.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
                    Rect rect = new Rect();
                    this.mPageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.jaR.showAtLocation(this.mRootView, 81, 0, this.mPageContext.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                    return;
                }
                cAe();
            }
        } else if (view == this.jaS) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), this.jaW == 1, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
    public void cAd() {
        if (this.jaW == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), true, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        } else if (!TextUtils.isEmpty(this.jaX)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.AB(this.jaX);
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
            aVar.b(this.mPageContext).bqz();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
    public void cAe() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
    }

    public EmotionCenterChangeView cAr() {
        return this.jaO;
    }
}
