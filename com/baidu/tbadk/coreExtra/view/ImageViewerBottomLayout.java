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
import com.baidu.tbadk.core.data.e;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.pageExtra.d;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int fwT = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private TextView eID;
    private AgreeView fjW;
    private ImageView fjY;
    private ImageView fkb;
    private ImageUrlData fvI;
    private a fwR;
    private TextView fwU;
    private ImageView fwV;
    private View fwW;
    private TextView fwX;
    private LinearLayout fwY;
    private ImageView fwZ;
    private c fxa;
    private b fxb;
    private Context mContext;
    private String mUserId;

    /* loaded from: classes.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bzu();
    }

    /* loaded from: classes.dex */
    public interface c {
        void bzv();
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.fwR = null;
        this.fxa = null;
        this.fxb = null;
        this.mContext = context;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.fwW = findViewById(R.id.unfold_root);
        this.fwU = (TextView) findViewById(R.id.unfold_text);
        this.fwV = (ImageView) findViewById(R.id.unfold_icon);
        this.fwW.setVisibility(8);
        WebPManager.a(this.fwV, R.drawable.icon_mask_unfold30, (WebPManager.ResourceStateType) null);
        this.fwX = (TextView) findViewById(R.id.image_viewer_reply);
        this.fwX.setText(R.string.image_viewer_reply);
        ap.setViewTextColor(this.fwX, R.color.CAM_X0101);
        this.fwX.setBackground(ap.aL(l.getDimens(context, R.dimen.tbds38), ap.getColor(R.color.CAM_X0615)));
        this.fwY = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        this.fjY = (ImageView) findViewById(R.id.comment_icon);
        WebPManager.a(this.fjY, R.drawable.icon_pure_card_comment22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        this.eID = (TextView) findViewById(R.id.comment_num);
        this.eID.setText("0");
        this.fjW = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.fjW.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
        this.fjW.setIsFromBigpic(true);
        this.fjW.setAgreeAlone(true);
        this.fjW.setAgreeAnimationResource();
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.fjW.getImgAgree().setAlpha(0.83f);
        } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            this.fjW.getImgAgree().setAlpha(0.92f);
        } else {
            this.fjW.getImgAgree().setAlpha(1.0f);
        }
        e eVar = new e();
        eVar.eMa = 13;
        eVar.eMg = 10;
        this.fjW.setStatisticData(eVar);
        this.fkb = (ImageView) findViewById(R.id.share_icon);
        WebPManager.a(this.fkb, R.drawable.icon_pure_expression22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        this.fwZ = (ImageView) findViewById(R.id.download_icon);
        WebPManager.a(this.fwZ, R.drawable.icon_pure_share_download22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
    }

    public void setExpandButtonListener(a aVar) {
        this.fwR = aVar;
    }

    public void setOnShareImageListener(c cVar) {
        this.fxa = cVar;
    }

    public void setOnDownloadImageListener(b bVar) {
        this.fxb = bVar;
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        this.fwX.setOnClickListener(onClickListener);
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.fvI = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.eID.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.fjW.setData(imageUrlData.agreeData);
            }
            this.fwW.setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    private void initListener() {
        this.fjY.setOnClickListener(this);
        this.eID.setOnClickListener(this);
        this.fkb.setOnClickListener(this);
        this.fwZ.setOnClickListener(this);
        this.fwW.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void kA(boolean z) {
        if (z) {
            this.fwU.setText(getContext().getString(R.string.expand));
            WebPManager.a(this.fwV, R.drawable.icon_mask_fold30, (WebPManager.ResourceStateType) null);
            this.fwY.setVisibility(8);
            this.fwX.setVisibility(8);
            return;
        }
        this.fwU.setText(getContext().getString(R.string.fold));
        WebPManager.a(this.fwV, R.drawable.icon_mask_unfold30, (WebPManager.ResourceStateType) null);
        this.fwY.setVisibility(0);
        this.fwX.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fjY || view == this.eID) {
            if (this.fvI != null) {
                ar arVar = new ar("c13685");
                arVar.v("tid", this.fvI.threadId);
                arVar.dR(IntentConfig.NID, this.fvI.nid);
                arVar.dR("fid", this.fvI.forumId);
                if (this.fvI.from == "index") {
                    arVar.ap("obj_locate", 1);
                } else if (this.fvI.from == "frs") {
                    arVar.ap("obj_locate", 2);
                } else if (this.fvI.from == "pb") {
                    arVar.ap("obj_locate", 3);
                }
                TiebaStatic.log(arVar);
            }
            com.baidu.tbadk.pageExtra.c bR = d.bR(view);
            ar arVar2 = new ar("c12942");
            arVar2.dR("obj_type", "2");
            arVar2.dR("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR);
            if (bR != null) {
                arVar2.dR("obj_cur_page", bR.getCurrentPageKey());
            }
            if (d.bDM() != null) {
                arVar2.dR("obj_pre_page", d.bDM());
            }
            TiebaStatic.log(arVar2);
            bzk();
        } else if (view == this.fkb) {
            if (this.fxa != null) {
                this.fxa.bzv();
            }
            if (this.fvI != null) {
                TiebaStatic.log(new ar("c13857").dR("obj_type", "9").v("post_id", this.fvI.threadId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.fvI.forumId));
            }
        } else if (view == this.fwZ) {
            if (this.fxb != null) {
                this.fxb.bzu();
            }
            if (this.fvI != null) {
                TiebaStatic.log(new ar("c13857").dR("obj_type", "2").v("post_id", this.fvI.threadId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.fvI.forumId));
            }
        } else if (view == this.fwW) {
            if (this.fwU.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.fwU.setText(getContext().getString(R.string.fold));
                WebPManager.a(this.fwV, R.drawable.icon_mask_unfold30, (WebPManager.ResourceStateType) null);
                if (this.fwR != null) {
                    this.fwR.a(this, true);
                }
            } else {
                this.fwU.setText(getContext().getString(R.string.expand));
                WebPManager.a(this.fwV, R.drawable.icon_mask_fold30, (WebPManager.ResourceStateType) null);
                if (this.fwR != null) {
                    this.fwR.a(this, false);
                }
            }
            TiebaStatic.log(new ar("c13857").dR("obj_type", "6").v("post_id", this.fvI.threadId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.fvI.forumId));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new ar("c13339").dR("uid", this.mUserId).v("post_id", this.fvI.threadId));
        return true;
    }

    private void bzk() {
        if (this.fvI != null) {
            String valueOf = String.valueOf(this.fvI.threadId);
            String valueOf2 = String.valueOf(this.fvI.postId);
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(valueOf, valueOf2, this.fvI.mIsSeeHost, this.fvI.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            createHistoryCfg.setHighLightPostId(valueOf2);
            createHistoryCfg.setStartFrom(23);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
