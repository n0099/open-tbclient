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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.d;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int fzl = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private TextView eLi;
    private AgreeView fmo;
    private ImageView fmr;
    private ImageView fmu;
    private ImageUrlData fxZ;
    private a fzj;
    private TextView fzm;
    private ImageView fzn;
    private View fzo;
    private TextView fzp;
    private LinearLayout fzq;
    private ImageView fzr;
    private c fzs;
    private b fzt;
    private Context mContext;
    private String mUserId;

    /* loaded from: classes.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bCV();
    }

    /* loaded from: classes.dex */
    public interface c {
        void bCW();
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.fzj = null;
        this.fzs = null;
        this.fzt = null;
        this.mContext = context;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.fzo = findViewById(R.id.unfold_root);
        this.fzm = (TextView) findViewById(R.id.unfold_text);
        this.fzn = (ImageView) findViewById(R.id.unfold_icon);
        this.fzo.setVisibility(8);
        WebPManager.a(this.fzn, R.drawable.icon_mask_unfold30, (WebPManager.ResourceStateType) null);
        this.fzp = (TextView) findViewById(R.id.image_viewer_reply);
        this.fzp.setText(R.string.image_viewer_reply);
        ao.setViewTextColor(this.fzp, R.color.CAM_X0101);
        this.fzp.setBackground(ao.aO(l.getDimens(context, R.dimen.tbds38), ao.getColor(R.color.CAM_X0615)));
        this.fzq = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        this.fmr = (ImageView) findViewById(R.id.comment_icon);
        WebPManager.a(this.fmr, R.drawable.icon_pure_card_comment22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        this.eLi = (TextView) findViewById(R.id.comment_num);
        this.eLi.setText("0");
        this.fmo = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.fmo.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
        this.fmo.setIsFromBigpic(true);
        this.fmo.setAgreeAlone(true);
        this.fmo.setAgreeAnimationResource();
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.fmo.getImgAgree().setAlpha(0.83f);
        } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            this.fmo.getImgAgree().setAlpha(0.92f);
        } else {
            this.fmo.getImgAgree().setAlpha(1.0f);
        }
        d dVar = new d();
        dVar.eOz = 13;
        dVar.eOF = 10;
        this.fmo.setStatisticData(dVar);
        this.fmu = (ImageView) findViewById(R.id.share_icon);
        WebPManager.a(this.fmu, R.drawable.icon_pure_expression22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        this.fzr = (ImageView) findViewById(R.id.download_icon);
        WebPManager.a(this.fzr, R.drawable.icon_pure_share_download22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
    }

    public void setExpandButtonListener(a aVar) {
        this.fzj = aVar;
    }

    public void setOnShareImageListener(c cVar) {
        this.fzs = cVar;
    }

    public void setOnDownloadImageListener(b bVar) {
        this.fzt = bVar;
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        this.fzp.setOnClickListener(onClickListener);
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.fxZ = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.eLi.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.fmo.setData(imageUrlData.agreeData);
            }
            this.fzo.setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    private void initListener() {
        this.fmr.setOnClickListener(this);
        this.eLi.setOnClickListener(this);
        this.fmu.setOnClickListener(this);
        this.fzr.setOnClickListener(this);
        this.fzo.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void kB(boolean z) {
        if (z) {
            this.fzm.setText(getContext().getString(R.string.expand));
            WebPManager.a(this.fzn, R.drawable.icon_mask_fold30, (WebPManager.ResourceStateType) null);
            this.fzq.setVisibility(8);
            this.fzp.setVisibility(8);
            return;
        }
        this.fzm.setText(getContext().getString(R.string.fold));
        WebPManager.a(this.fzn, R.drawable.icon_mask_unfold30, (WebPManager.ResourceStateType) null);
        this.fzq.setVisibility(0);
        this.fzp.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fmr || view == this.eLi) {
            if (this.fxZ != null) {
                aq aqVar = new aq("c13685");
                aqVar.w("tid", this.fxZ.threadId);
                aqVar.dX(IntentConfig.NID, this.fxZ.nid);
                aqVar.dX("fid", this.fxZ.forumId);
                if (this.fxZ.from == "index") {
                    aqVar.an("obj_locate", 1);
                } else if (this.fxZ.from == "frs") {
                    aqVar.an("obj_locate", 2);
                } else if (this.fxZ.from == "pb") {
                    aqVar.an("obj_locate", 3);
                }
                TiebaStatic.log(aqVar);
            }
            com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(view);
            aq aqVar2 = new aq("c12942");
            aqVar2.dX("obj_type", "2");
            aqVar2.dX("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR);
            if (bV != null) {
                aqVar2.dX("obj_cur_page", bV.getCurrentPageKey());
            }
            if (com.baidu.tbadk.pageExtra.d.bHm() != null) {
                aqVar2.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHm());
            }
            TiebaStatic.log(aqVar2);
            bCL();
        } else if (view == this.fmu) {
            if (this.fzs != null) {
                this.fzs.bCW();
            }
            if (this.fxZ != null) {
                TiebaStatic.log(new aq("c13857").dX("obj_type", "9").w("post_id", this.fxZ.threadId).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fid", this.fxZ.forumId));
            }
        } else if (view == this.fzr) {
            if (this.fzt != null) {
                this.fzt.bCV();
            }
            if (this.fxZ != null) {
                TiebaStatic.log(new aq("c13857").dX("obj_type", "2").w("post_id", this.fxZ.threadId).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fid", this.fxZ.forumId));
            }
        } else if (view == this.fzo) {
            if (this.fzm.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.fzm.setText(getContext().getString(R.string.fold));
                WebPManager.a(this.fzn, R.drawable.icon_mask_unfold30, (WebPManager.ResourceStateType) null);
                if (this.fzj != null) {
                    this.fzj.a(this, true);
                }
            } else {
                this.fzm.setText(getContext().getString(R.string.expand));
                WebPManager.a(this.fzn, R.drawable.icon_mask_fold30, (WebPManager.ResourceStateType) null);
                if (this.fzj != null) {
                    this.fzj.a(this, false);
                }
            }
            TiebaStatic.log(new aq("c13857").dX("obj_type", "6").w("post_id", this.fxZ.threadId).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fid", this.fxZ.forumId));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new aq("c13339").dX("uid", this.mUserId).w("post_id", this.fxZ.threadId));
        return true;
    }

    private void bCL() {
        if (this.fxZ != null) {
            String valueOf = String.valueOf(this.fxZ.threadId);
            String valueOf2 = String.valueOf(this.fxZ.postId);
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(valueOf, valueOf2, this.fxZ.mIsSeeHost, this.fxZ.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            createHistoryCfg.setHighLightPostId(valueOf2);
            createHistoryCfg.setStartFrom(23);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
