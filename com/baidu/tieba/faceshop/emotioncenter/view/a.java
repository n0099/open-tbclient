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
/* loaded from: classes8.dex */
public class a implements View.OnClickListener, c {
    private g gGD;
    private BdTypeListView gwr;
    private NoNetworkView gxx;
    private PbListView gxy;
    private View iTe;
    private RelativeLayout iTf;
    private TextView iTg;
    private ImageView iTh;
    private com.baidu.tieba.faceshop.emotioncenter.a iTi;
    private EmotionCenterForumView iTj;
    private EmotionCenterChangeView iTk;
    private com.baidu.tieba.faceshop.emotioncenter.adapter.a iTl;
    private EmotionCenterData iTm;
    private com.baidu.tieba.faceshop.emotioncenter.a.a iTn;
    private LinearLayout iTo;
    private ImageView iTp;
    private TextView iTq;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;
    private Animation iTa = null;
    private boolean iTr = true;
    private int iTs = 0;
    private String iTt = "";

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.mRootView = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_emotion_center_layout, (ViewGroup) null);
        this.gxx = new NoNetworkView(tbPageContext.getPageActivity());
        this.gxx.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        if (j.isNetWorkAvailable()) {
            this.gxx.setVisibility(8);
        }
        this.mRootView.addView(this.gxx);
        this.gwr = (BdTypeListView) this.mRootView.findViewById(R.id.emotion_center_list);
        this.gwr.setDivider(null);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.mPullView.setTag(bdUniqueId);
        this.gwr.setPullRefresh(this.mPullView);
        this.gxy = new PbListView(tbPageContext.getPageActivity());
        this.gxy.createView();
        this.iTi = new com.baidu.tieba.faceshop.emotioncenter.a(this.mPageContext);
        this.iTi.getView().setVisibility(8);
        this.iTj = new EmotionCenterForumView(this.mPageContext);
        this.iTj.setVisibility(8);
        this.iTl = new com.baidu.tieba.faceshop.emotioncenter.adapter.a(this.mPageContext, this.gwr);
        this.iTk = new EmotionCenterChangeView(this.mPageContext);
        this.iTk.setVisibility(8);
        this.gwr.addHeaderView(this.iTi.getView());
        this.gwr.addHeaderView(this.iTj);
        this.gwr.addHeaderView(this.iTk);
        this.iTe = this.mRootView.findViewById(R.id.emotion_add_layout);
        this.iTf = (RelativeLayout) this.mRootView.findViewById(R.id.emotion_add_layout);
        this.iTg = (TextView) this.mRootView.findViewById(R.id.add_emotion_tv);
        this.iTh = (ImageView) this.mRootView.findViewById(R.id.icon_add);
        this.iTe.setOnClickListener(this);
        this.iTo = (LinearLayout) this.mRootView.findViewById(R.id.emotion_upload_status);
        this.iTo.setClickable(false);
        this.iTo.setOnClickListener(this);
        this.iTo.setVisibility(8);
        this.iTp = (ImageView) this.mRootView.findViewById(R.id.uploading_status_img);
        this.iTq = (TextView) this.mRootView.findViewById(R.id.add_emotion_upload_status);
        showLoadingView();
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.gGD = new g(this.mPageContext.getPageActivity());
            this.gGD.attachView(this.mRootView, false);
            this.gGD.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this.mRootView);
            this.gGD = null;
        }
    }

    public ViewGroup getView() {
        return this.mRootView;
    }

    public View cyO() {
        return this.gxx;
    }

    public void a(EmotionPackageData emotionPackageData) {
        if (emotionPackageData != null) {
            if (this.iTk != null) {
                this.iTk.a(emotionPackageData);
            }
            if (this.iTl != null) {
                this.iTl.a(emotionPackageData);
            }
        }
    }

    public void d(EmotionCenterData emotionCenterData) {
        if (emotionCenterData != null) {
            hideLoadingView();
            if (x.isEmpty(this.iTk.getDataList())) {
                this.iTk.cyL();
                this.iTk.setVisibility(0);
            }
            this.iTm = emotionCenterData;
            if (this.iTr) {
                this.iTs = b.toInt(emotionCenterData.is_bazhu, 0);
                this.iTt = emotionCenterData.bazhu_message;
                this.iTr = false;
            }
            if (emotionCenterData.banner != null) {
                this.iTi.getView().setVisibility(0);
                this.iTi.l(this.mPageContext.getUniqueId());
                this.iTi.a(new com.baidu.tieba.faceshop.emotioncenter.data.c(emotionCenterData.banner));
                this.iTi.bvb();
            }
            if (emotionCenterData.forum != null) {
                this.iTj.setVisibility(0);
                this.iTj.setData(emotionCenterData.forum);
            }
            if (!x.isEmpty(emotionCenterData.package_list)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.tieba.faceshop.emotioncenter.data.a());
                for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                    com.baidu.tieba.faceshop.emotioncenter.data.b bVar = new com.baidu.tieba.faceshop.emotioncenter.data.b();
                    bVar.iSA = emotionPackageData;
                    arrayList.add(bVar);
                }
                this.iTl.setDatas(arrayList);
            }
            this.iTl.notifyDataSetChanged();
        }
    }

    public void e(EmotionCenterData emotionCenterData) {
        if (emotionCenterData != null) {
            this.iTm = emotionCenterData;
            if (!x.isEmpty(this.iTm.package_list)) {
                ArrayList arrayList = new ArrayList();
                for (EmotionPackageData emotionPackageData : emotionCenterData.package_list) {
                    com.baidu.tieba.faceshop.emotioncenter.data.b bVar = new com.baidu.tieba.faceshop.emotioncenter.data.b();
                    bVar.iSA = emotionPackageData;
                    arrayList.add(bVar);
                }
                this.iTl.cJ(arrayList);
            }
            this.iTl.notifyDataSetChanged();
        }
    }

    public void cyP() {
        if (this.iTn != null) {
            this.iTn.dismiss();
        }
        endAnimation();
        this.iTo.setVisibility(8);
        this.iTe.setVisibility(0);
    }

    public void cyQ() {
        if (this.iTn != null) {
            this.iTn.dismiss();
        }
        startAnimation();
        this.iTo.setVisibility(0);
        this.iTe.setVisibility(8);
        ao.setBackgroundColor(this.iTo, R.color.CAM_X0201);
        ao.setImageResource(this.iTp, R.drawable.emotion_uploading_bar_refresh);
        ao.setViewTextColor(this.iTq, R.color.CAM_X0302);
        this.iTq.setText(R.string.emotion_uploading);
        this.iTo.setClickable(false);
    }

    public void cyR() {
        if (this.iTn != null) {
            this.iTn.dismiss();
        }
        endAnimation();
        this.iTo.setVisibility(0);
        this.iTe.setVisibility(8);
        ao.setBackgroundColor(this.iTo, R.color.CAM_X0201);
        ao.setImageResource(this.iTp, R.drawable.emotion_update_fail);
        ao.setViewTextColor(this.iTq, R.color.common_color_10037);
        this.iTq.setText(R.string.emotion_center_upload_failed);
        this.iTo.setClickable(true);
    }

    private Animation getClickRotateAnimation() {
        if (this.iTa == null) {
            this.iTa = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.refresh_rotate);
            this.iTa.setInterpolator(new LinearInterpolator());
            this.iTa.setFillAfter(true);
        }
        return this.iTa;
    }

    public void startAnimation() {
        if (this.iTp != null) {
            this.iTp.startAnimation(getClickRotateAnimation());
        }
    }

    public void endAnimation() {
        if (this.iTp != null) {
            this.iTp.clearAnimation();
        }
    }

    public int cyS() {
        return this.iTs;
    }

    public void completePullRefresh() {
        this.gwr.completePullRefresh();
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void bQM() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.gwr.setNextPage(this.gxy);
            }
            this.gxy.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.gxy.endLoadData();
        }
    }

    public void bQN() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.gwr.setNextPage(this.gxy);
            }
            this.gxy.showLoadingViewWithoutEmptyView();
            this.gxy.startLoadData();
        }
    }

    public void bRO() {
        if (this.gxy != null) {
            this.gxy.endLoadData();
        }
        this.gwr.setNextPage(null);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.gwr.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gxy.changeSkin(i);
        this.mPullView.changeSkin(i);
        this.iTl.notifyDataSetChanged();
        ao.setBackgroundColor(this.iTf, R.color.CAM_X0201);
        this.gwr.setBackgroundColor(ao.getColor(R.color.CAM_X0201));
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.gxx.onChangeSkinType(this.mPageContext, i);
        if (this.iTj != null) {
            this.iTj.onChangeSkin(i);
        }
        if (this.iTf != null) {
            ao.setBackgroundColor(this.iTf, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iTg != null) {
            ao.setViewTextColor(this.iTg, R.color.CAM_X0302, i);
        }
        if (this.iTh != null) {
            ao.setImageResource(this.iTh, R.drawable.emotion_bar_add_icon);
        }
        if (this.iTo != null) {
            ao.setBackgroundColor(this.iTf, R.color.cp_bg_line_d_alpha90, i);
        }
        if (this.iTp != null) {
            ao.setImageResource(this.iTp, R.drawable.emotion_uploading_bar_refresh);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iTe) {
            if (this.iTm != null) {
                if (this.iTs != 0) {
                    if (this.iTn == null) {
                        this.iTn = new com.baidu.tieba.faceshop.emotioncenter.a.a(this.mPageContext.getPageActivity(), this.iTs);
                        this.iTn.a(this);
                    }
                    this.iTn.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
                    Rect rect = new Rect();
                    this.mPageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                    this.iTn.showAtLocation(this.mRootView, 81, 0, this.mPageContext.getPageActivity().getWindow().getDecorView().getHeight() - rect.bottom);
                    return;
                }
                cyG();
            }
        } else if (view == this.iTo) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), this.iTs == 1, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
    public void cyF() {
        if (this.iTs == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), true, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        } else if (!TextUtils.isEmpty(this.iTt)) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            aVar.Ad(this.iTt);
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
            aVar.b(this.mPageContext).bqe();
        }
    }

    @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
    public void cyG() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
    }

    public EmotionCenterChangeView cyT() {
        return this.iTk;
    }
}
