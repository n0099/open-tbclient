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
    public static final int fys = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private TextView eKe;
    private ImageView flA;
    private AgreeView flv;
    private ImageView flx;
    private ImageUrlData fxh;
    private b fyA;
    private a fyq;
    private TextView fyt;
    private ImageView fyu;
    private View fyv;
    private TextView fyw;
    private LinearLayout fyx;
    private ImageView fyy;
    private c fyz;
    private Context mContext;
    private String mUserId;

    /* loaded from: classes.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bzx();
    }

    /* loaded from: classes.dex */
    public interface c {
        void bzy();
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.fyq = null;
        this.fyz = null;
        this.fyA = null;
        this.mContext = context;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.fyv = findViewById(R.id.unfold_root);
        this.fyt = (TextView) findViewById(R.id.unfold_text);
        this.fyu = (ImageView) findViewById(R.id.unfold_icon);
        this.fyv.setVisibility(8);
        WebPManager.a(this.fyu, R.drawable.icon_mask_unfold30, (WebPManager.ResourceStateType) null);
        this.fyw = (TextView) findViewById(R.id.image_viewer_reply);
        this.fyw.setText(R.string.image_viewer_reply);
        ap.setViewTextColor(this.fyw, R.color.CAM_X0101);
        this.fyw.setBackground(ap.aL(l.getDimens(context, R.dimen.tbds38), ap.getColor(R.color.CAM_X0615)));
        this.fyx = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        this.flx = (ImageView) findViewById(R.id.comment_icon);
        WebPManager.a(this.flx, R.drawable.icon_pure_card_comment22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        this.eKe = (TextView) findViewById(R.id.comment_num);
        this.eKe.setText("0");
        this.flv = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.flv.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
        this.flv.setIsFromBigpic(true);
        this.flv.setAgreeAlone(true);
        this.flv.setAgreeAnimationResource();
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.flv.getImgAgree().setAlpha(0.83f);
        } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            this.flv.getImgAgree().setAlpha(0.92f);
        } else {
            this.flv.getImgAgree().setAlpha(1.0f);
        }
        e eVar = new e();
        eVar.eNB = 13;
        eVar.eNH = 10;
        this.flv.setStatisticData(eVar);
        this.flA = (ImageView) findViewById(R.id.share_icon);
        WebPManager.a(this.flA, R.drawable.icon_pure_expression22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        this.fyy = (ImageView) findViewById(R.id.download_icon);
        WebPManager.a(this.fyy, R.drawable.icon_pure_share_download22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
    }

    public void setExpandButtonListener(a aVar) {
        this.fyq = aVar;
    }

    public void setOnShareImageListener(c cVar) {
        this.fyz = cVar;
    }

    public void setOnDownloadImageListener(b bVar) {
        this.fyA = bVar;
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        this.fyw.setOnClickListener(onClickListener);
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.fxh = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.eKe.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.flv.setData(imageUrlData.agreeData);
            }
            this.fyv.setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    private void initListener() {
        this.flx.setOnClickListener(this);
        this.eKe.setOnClickListener(this);
        this.flA.setOnClickListener(this);
        this.fyy.setOnClickListener(this);
        this.fyv.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void kA(boolean z) {
        if (z) {
            this.fyt.setText(getContext().getString(R.string.expand));
            WebPManager.a(this.fyu, R.drawable.icon_mask_fold30, (WebPManager.ResourceStateType) null);
            this.fyx.setVisibility(8);
            this.fyw.setVisibility(8);
            return;
        }
        this.fyt.setText(getContext().getString(R.string.fold));
        WebPManager.a(this.fyu, R.drawable.icon_mask_unfold30, (WebPManager.ResourceStateType) null);
        this.fyx.setVisibility(0);
        this.fyw.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.flx || view == this.eKe) {
            if (this.fxh != null) {
                ar arVar = new ar("c13685");
                arVar.v("tid", this.fxh.threadId);
                arVar.dR(IntentConfig.NID, this.fxh.nid);
                arVar.dR("fid", this.fxh.forumId);
                if (this.fxh.from == "index") {
                    arVar.aq("obj_locate", 1);
                } else if (this.fxh.from == "frs") {
                    arVar.aq("obj_locate", 2);
                } else if (this.fxh.from == "pb") {
                    arVar.aq("obj_locate", 3);
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
            if (d.bDP() != null) {
                arVar2.dR("obj_pre_page", d.bDP());
            }
            TiebaStatic.log(arVar2);
            bzn();
        } else if (view == this.flA) {
            if (this.fyz != null) {
                this.fyz.bzy();
            }
            if (this.fxh != null) {
                TiebaStatic.log(new ar("c13857").dR("obj_type", "9").v("post_id", this.fxh.threadId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.fxh.forumId));
            }
        } else if (view == this.fyy) {
            if (this.fyA != null) {
                this.fyA.bzx();
            }
            if (this.fxh != null) {
                TiebaStatic.log(new ar("c13857").dR("obj_type", "2").v("post_id", this.fxh.threadId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.fxh.forumId));
            }
        } else if (view == this.fyv) {
            if (this.fyt.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.fyt.setText(getContext().getString(R.string.fold));
                WebPManager.a(this.fyu, R.drawable.icon_mask_unfold30, (WebPManager.ResourceStateType) null);
                if (this.fyq != null) {
                    this.fyq.a(this, true);
                }
            } else {
                this.fyt.setText(getContext().getString(R.string.expand));
                WebPManager.a(this.fyu, R.drawable.icon_mask_fold30, (WebPManager.ResourceStateType) null);
                if (this.fyq != null) {
                    this.fyq.a(this, false);
                }
            }
            TiebaStatic.log(new ar("c13857").dR("obj_type", "6").v("post_id", this.fxh.threadId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.fxh.forumId));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new ar("c13339").dR("uid", this.mUserId).v("post_id", this.fxh.threadId));
        return true;
    }

    private void bzn() {
        if (this.fxh != null) {
            String valueOf = String.valueOf(this.fxh.threadId);
            String valueOf2 = String.valueOf(this.fxh.postId);
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(valueOf, valueOf2, this.fxh.mIsSeeHost, this.fxh.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            createHistoryCfg.setHighLightPostId(valueOf2);
            createHistoryCfg.setStartFrom(23);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
