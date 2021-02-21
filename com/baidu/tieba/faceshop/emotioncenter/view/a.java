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
    private NoNetworkView gAv;
    private PbListView gAw;
    private g gJB;
    private BdTypeListView gzp;
    private View iYZ;
    private RelativeLayout iZa;
    private TextView iZb;
    private ImageView iZc;
    private com.baidu.tieba.faceshop.emotioncenter.a iZd;
    private EmotionCenterForumView iZe;
    private EmotionCenterChangeView iZf;
    private com.baidu.tieba.faceshop.emotioncenter.adapter.a iZg;
    private EmotionCenterData iZh;
    private com.baidu.tieba.faceshop.emotioncenter.a.a iZi;
    private LinearLayout iZj;
    private ImageView iZk;
    private TextView iZl;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;
    private Animation iYV = null;
    private boolean iZm = true;
    private int iZn = 0;
    private String iZo = "";

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mRootView = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_emotion_center_layout, (ViewGroup) null);
        this.gAv = new NoNetworkView(tbPageContext.getPageActivity());
        this.gAv.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        if (j.isNetWorkAvailable()) {
            this.gAv.setVisibility(8);
        }
        this.mRootView.addView(this.gAv);
        this.gzp = (BdTypeListView) this.mRootView.findViewById(R.id.emotion_center_list);
        this.gzp.setDivider(null);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.gzp.setPullRefresh(this.mPullView);
        this.gAw = new PbListView(tbPageContext.getPageActivity());
        this.gAw.createView();
        this.iZd = new com.baidu.tieba.faceshop.emotioncenter.a(this.mPageContext);
        this.iZd.getView().setVisibility(8);
        this.iZe = new EmotionCenterForumView(this.mPageContext);
        this.iZe.setVisibility(8);
        this.iZg = new com.baidu.tieba.faceshop.emotioncenter.adapter.a(this.mPageContext, this.gzp);
        this.iZf = new EmotionCenterChangeView(this.mPageContext);
        this.iZf.setVisibility(8);
        this.gzp.addHeaderView(this.iZd.getView());
        this.gzp.addHeaderView(this.iZe);
        this.gzp.addHeaderView(this.iZf);
        this.iYZ = this.mRootView.findViewById(R.id.emotion_add_layout);
        this.iZa = (RelativeLayout) this.mRootView.findViewById(R.id.emotion_add_layout);
        this.iZb = (TextView) this.mRootView.findViewById(R.id.add_emotion_tv);
        this.iZc = (ImageView) this.mRootView.findViewById(R.id.icon_add);
        this.iYZ.setOnClickListener(this);
        this.iZj = (LinearLayout) this.mRootView.findViewById(R.id.emotion_upload_status);
        this.iZj.setClickable(false);
        this.iZj.setOnClickListener(this);
        this.iZj.setVisibility(8);
        this.iZk = (ImageView) this.mRootView.findViewById(R.id.uploading_status_img);
        this.iZl = (TextView) this.mRootView.findViewById(R.id.add_emotion_upload_status);
        showLoadingView();
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.gJB = new g(this.mPageContext.getPageActivity());
            this.gJB.attachView(this.mRootView, false);
            this.gJB.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this.mRootView);
            this.gJB = null;
        }
    }

    public ViewGroup getView() {
        return this.mRootView;
    }

    public View cAg() {
        return this.gAv;
    }

    public void a(EmotionPackageData emotionPackageData) {
        if (emotionPackageData != null) {
            if (this.iZf != null) {
                this.iZf.a(emotionPackageData);
            }
            if (this.iZg != null) {
                this.iZg.a(emotionPackageData);
            }
        }
    }

    public void d(EmotionCenterData emotionCenterData) {
        if (emotionCenterData != null) {
            hideLoadingView();
            if (y.isEmpty(this.iZf.getDataList())) {
                this.iZf.cAd();
                this.iZf.setVisibility(0);
            }
            this.iZh = emotionCenterData;
            if (this.iZm) {
                this.iZn = b.toInt(emotionCenterData.is_bazhu, 0);
                this.iZo = emotionCenterData.bazhu_message;
                this.iZm = false;
            }
            if (emotionCenterData.banner != null) {
                this.iZd.getView().setVisibility(0);
                this.iZd.l(this.mPageContext.getUniqueId());
                this.iZd.a(new com.baidu.tieba.faceshop.emotioncenter.data.c(emotionCenterData.banner));
                this.iZd.bvv();
            }
            if (emotionCenterData.forum != null) {
                this.iZe.setVisibility(0);
                this.iZe.setData(emotionCenterData.forum);
            }
            if (!y.isEmpty(emotionCenterData.package_list)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.tieba.faceshop.emotioncenter.data.a());
                for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                    com.baidu.tieba.faceshop.emotioncenter.data.b bVar = new com.baidu.tieba.faceshop.emotioncenter.data.b();
                    bVar.iYv = emotionPackageData;
                    arrayList.add(bVar);
                }
                this.iZg.setDatas(arrayList);
            }
            this.iZg.notifyDataSetChanged();
        }
    }

    public void e(EmotionCenterData emotionCenterData) {
        if (emotionCenterData != null) {
            this.iZh = emotionCenterData;
            if (!y.isEmpty(this.iZh.package_list)) {
                ArrayList arrayList = new ArrayList();
                for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                    com.baidu.tieba.faceshop.emotioncenter.data.b bVar = new com.baidu.tieba.faceshop.emotioncenter.data.b();
                    bVar.iYv = emotionPackageData;
                    arrayList.add(bVar);
                }
                this.iZg.cE(arrayList);
            }
            this.iZg.notifyDataSetChanged();
        }
    }

    public void cAh() {
        if (this.iZi != null) {
            this.iZi.dismiss();
        }
        endAnimation();
        this.iZj.setVisibility(8);
        this.iYZ.setVisibility(0);
    }

    public void cAi() {
        if (this.iZi != null) {
            this.iZi.dismiss();
        }
        startAnimation();
        this.iZj.setVisibility(0);
        this.iYZ.setVisibility(8);
        ap.setBackgroundColor(this.iZj, R.color.CAM_X0201);
        ap.setImageResource(this.iZk, R.drawable.emotion_uploading_bar_refresh);
        ap.setViewTextColor(this.iZl, R.color.CAM_X0302);
        this.iZl.setText(R.string.emotion_uploading);
        this.iZj.setClickable(false);
    }

    public void cAj() {
        if (this.iZi != null) {
            this.iZi.dismiss();
        }
        endAnimation();
        this.iZj.setVisibility(0);
        this.iYZ.setVisibility(8);
        ap.setBackgroundColor(this.iZj, R.color.CAM_X0201);
        ap.setImageResource(this.iZk, R.drawable.emotion_update_fail);
        ap.setViewTextColor(this.iZl, R.color.common_color_10037);
        this.iZl.setText(R.string.emotion_center_upload_failed);
        this.iZj.setClickable(true);
    }

    private Animation getClickRotateAnimation() {
        if (this.iYV == null) {
            this.iYV = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.refresh_rotate);
            this.iYV.setInterpolator(new LinearInterpolator());
            this.iYV.setFillAfter(true);
        }
        return this.iYV;
    }

    public void startAnimation() {
        if (this.iZk != null) {
            this.iZk.startAnimation(getClickRotateAnimation());
        }
    }

    public void endAnimation() {
        if (this.iZk != null) {
            this.iZk.clearAnimation();
        }
    }

    public int cAk() {
        return this.iZn;
    }

    public void completePullRefresh() {
        this.gzp.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bRx() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.gzp.setNextPage(this.gAw);
            }
            this.gAw.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gAw.endLoadData();
        }
    }

    public void bRy() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.gzp.setNextPage(this.gAw);
            }
            this.gAw.showLoadingViewWithoutEmptyView();
            this.gAw.startLoadData();
        }
    }

    public void bSy() {
        if (this.gAw != null) {
            this.gAw.endLoadData();
        }
        this.gzp.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.gzp.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gAw.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.iZg.notifyDataSetChanged();
        ap.setBackgroundColor(this.iZa, R.color.CAM_X0201);
        this.gzp.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.gAv.onChangeSkinType(this.mPageContext, i);
        if (this.iZe != null) {
            this.iZe.onChangeSkin(i);
        }
        if (this.iZa != null) {
            ap.setBackgroundColor(this.iZa, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iZb != null) {
            ap.setViewTextColor(this.iZb, R.color.CAM_X0302, i);
        }
        if (this.iZc != null) {
            ap.setImageResource(this.iZc, R.drawable.emotion_bar_add_icon);
        }
        if (this.iZj != null) {
            ap.setBackgroundColor(this.iZa, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iZk != null) {
            ap.setImageResource(this.iZk, R.drawable.emotion_uploading_bar_refresh);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iYZ) {
            if (this.iZh != null) {
                if (this.iZn != 0) {
                    if (this.iZi == null) {
                        this.iZi = new com.baidu.tieba.faceshop.emotioncenter.a.a(this.mPageContext.getPageActivity(), this.iZn);
                        this.iZi.a(this);
                    }
                    this.iZi.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
                    Rect rect = new Rect();
                    this.mPageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.iZi.showAtLocation(this.mRootView, 81, 0, this.mPageContext.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                    return;
                }
                czY();
            }
        } else if (view == this.iZj) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), this.iZn == 1, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
    public void czX() {
        if (this.iZn == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), true, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        } else if (!TextUtils.isEmpty(this.iZo)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.Au(this.iZo);
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
    public void czY() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
    }

    public EmotionCenterChangeView cAl() {
        return this.iZf;
    }
}
