package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import d.a.c.e.p.l;
import d.a.n0.r.q.e;
/* loaded from: classes3.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int v = l.g(TbadkApplication.getInst(), R.dimen.tbds130);

    /* renamed from: e  reason: collision with root package name */
    public ImageUrlData f12795e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12796f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f12797g;

    /* renamed from: h  reason: collision with root package name */
    public View f12798h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12799i;
    public LinearLayout j;
    public AgreeView k;
    public ImageView l;
    public TextView m;
    public ImageView n;
    public ImageView o;
    public String p;
    public a q;
    public c r;
    public b s;
    public Context t;
    public boolean u;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onSave();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = context;
        a(context);
        b();
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.f12798h = findViewById(R.id.unfold_root);
        this.f12796f = (TextView) findViewById(R.id.unfold_text);
        this.f12797g = (ImageView) findViewById(R.id.unfold_icon);
        this.f12798h.setVisibility(8);
        WebPManager.setMaskDrawable(this.f12797g, R.drawable.icon_mask_unfold30, null);
        TextView textView = (TextView) findViewById(R.id.image_viewer_reply);
        this.f12799i = textView;
        textView.setText(R.string.image_viewer_reply);
        SkinManager.setViewTextColor(this.f12799i, R.color.CAM_X0101);
        this.f12799i.setBackground(SkinManager.createShapeDrawableFromColor(l.g(context, R.dimen.tbds38), SkinManager.getColor(R.color.CAM_X0615)));
        this.j = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        ImageView imageView = (ImageView) findViewById(R.id.comment_icon);
        this.l = imageView;
        WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_comment22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        TextView textView2 = (TextView) findViewById(R.id.comment_num);
        this.m = textView2;
        textView2.setText("0");
        AgreeView agreeView = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.k = agreeView;
        agreeView.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
        this.k.setIsFromBigpic(true);
        this.k.setAgreeAlone(true);
        this.k.setAgreeAnimationResource();
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.k.getImgAgree().setAlpha(0.83f);
        } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            this.k.getImgAgree().setAlpha(0.92f);
        } else {
            this.k.getImgAgree().setAlpha(1.0f);
        }
        e eVar = new e();
        eVar.f53777b = 13;
        eVar.f53783h = 10;
        this.k.setStatisticData(eVar);
        ImageView imageView2 = (ImageView) findViewById(R.id.share_icon);
        this.n = imageView2;
        WebPManager.setPureDrawable(imageView2, R.drawable.icon_pure_expression22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        ImageView imageView3 = (ImageView) findViewById(R.id.download_icon);
        this.o = imageView3;
        WebPManager.setPureDrawable(imageView3, R.drawable.icon_pure_share_download22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
    }

    public final void b() {
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.f12798h.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public final void c() {
        ImageUrlData imageUrlData = this.f12795e;
        if (imageUrlData == null) {
            return;
        }
        String valueOf = String.valueOf(imageUrlData.threadId);
        String valueOf2 = String.valueOf(this.f12795e.postId);
        PbActivityConfig pbActivityConfig = new PbActivityConfig(getContext());
        ImageUrlData imageUrlData2 = this.f12795e;
        PbActivityConfig createHistoryCfg = pbActivityConfig.createHistoryCfg(valueOf, valueOf2, imageUrlData2.mIsSeeHost, imageUrlData2.mIsReserver, null);
        createHistoryCfg.setJumpToCommentArea(true);
        createHistoryCfg.setHighLightPostId(valueOf2);
        createHistoryCfg.setStartFrom(23);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
    }

    public void d(ImageUrlData imageUrlData) {
        this.f12795e = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            String str = imageUrlData.commentNum;
            if (str != null) {
                this.m.setText(str);
            }
            AgreeData agreeData = imageUrlData.agreeData;
            if (agreeData != null) {
                this.k.setData(agreeData);
            }
            if (this.u) {
                return;
            }
            this.f12798h.setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    public void e(boolean z) {
        if (z) {
            this.f12796f.setText(getContext().getString(R.string.expand));
            WebPManager.setMaskDrawable(this.f12797g, R.drawable.icon_mask_fold30, null);
            this.j.setVisibility(8);
            this.f12799i.setVisibility(8);
            return;
        }
        this.f12796f.setText(getContext().getString(R.string.fold));
        WebPManager.setMaskDrawable(this.f12797g, R.drawable.icon_mask_unfold30, null);
        this.j.setVisibility(0);
        this.f12799i.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.l && view != this.m) {
            if (view == this.n) {
                c cVar = this.r;
                if (cVar != null) {
                    cVar.a();
                }
                if (this.f12795e != null) {
                    TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "9").param("post_id", this.f12795e.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f12795e.forumId));
                    return;
                }
                return;
            } else if (view == this.o) {
                b bVar = this.s;
                if (bVar != null) {
                    bVar.onSave();
                }
                if (this.f12795e != null) {
                    TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "2").param("post_id", this.f12795e.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f12795e.forumId));
                    return;
                }
                return;
            } else if (view == this.f12798h) {
                if (this.f12796f.getText().toString().equals(getContext().getString(R.string.expand))) {
                    this.f12796f.setText(getContext().getString(R.string.fold));
                    WebPManager.setMaskDrawable(this.f12797g, R.drawable.icon_mask_unfold30, null);
                    a aVar = this.q;
                    if (aVar != null) {
                        aVar.a(this, true);
                    }
                } else {
                    this.f12796f.setText(getContext().getString(R.string.expand));
                    WebPManager.setMaskDrawable(this.f12797g, R.drawable.icon_mask_fold30, null);
                    a aVar2 = this.q;
                    if (aVar2 != null) {
                        aVar2.a(this, false);
                    }
                }
                TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "6").param("post_id", this.f12795e.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f12795e.forumId));
                return;
            } else {
                return;
            }
        }
        if (this.f12795e != null) {
            StatisticItem statisticItem = new StatisticItem("c13685");
            statisticItem.param("tid", this.f12795e.threadId);
            statisticItem.param("nid", this.f12795e.nid);
            statisticItem.param("fid", this.f12795e.forumId);
            String str = this.f12795e.from;
            if (str == "index") {
                statisticItem.param("obj_locate", 1);
            } else if (str == "frs") {
                statisticItem.param("obj_locate", 2);
            } else if (str == "pb") {
                statisticItem.param("obj_locate", 3);
            }
            TiebaStatic.log(statisticItem);
        }
        d.a.n0.i0.c f2 = TbPageExtraHelper.f(view);
        StatisticItem statisticItem2 = new StatisticItem("c12942");
        statisticItem2.param("obj_type", "2");
        statisticItem2.param("obj_locate", "12");
        if (f2 != null) {
            statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
        }
        if (TbPageExtraHelper.m() != null) {
            statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
        }
        TiebaStatic.log(statisticItem2);
        c();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new StatisticItem("c13339").param("uid", this.p).param("post_id", this.f12795e.threadId));
        return true;
    }

    public void setExpandButtonListener(a aVar) {
        this.q = aVar;
    }

    public void setOnDownloadImageListener(b bVar) {
        this.s = bVar;
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        this.f12799i.setOnClickListener(onClickListener);
    }

    public void setOnShareImageListener(c cVar) {
        this.r = cVar;
    }

    public void setUserId(String str) {
        this.p = str;
    }

    public void setYoungterCoverSomeView(boolean z) {
        this.u = z;
        this.f12799i.setVisibility(z ? 8 : 0);
        this.l.setVisibility(z ? 8 : 0);
        this.m.setVisibility(z ? 8 : 0);
        this.k.setVisibility(z ? 8 : 0);
        this.n.setVisibility(z ? 8 : 0);
    }
}
