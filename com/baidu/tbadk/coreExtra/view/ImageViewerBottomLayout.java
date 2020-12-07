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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int fpE = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private TextView eBF;
    private AgreeView fcF;
    private ImageView fcH;
    private ImageView fcK;
    private ImageUrlData foq;
    private a fpC;
    private TextView fpF;
    private ImageView fpG;
    private View fpH;
    private TextView fpI;
    private LinearLayout fpJ;
    private ImageView fpK;
    private c fpL;
    private b fpM;
    private Context mContext;
    private String mUserId;

    /* loaded from: classes21.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void bAB();
    }

    /* loaded from: classes21.dex */
    public interface c {
        void bAC();
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.fpC = null;
        this.fpL = null;
        this.fpM = null;
        this.mContext = context;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.fpH = findViewById(R.id.unfold_root);
        this.fpF = (TextView) findViewById(R.id.unfold_text);
        this.fpG = (ImageView) findViewById(R.id.unfold_icon);
        this.fpH.setVisibility(8);
        SvgManager.btW().a(this.fpG, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        this.fpI = (TextView) findViewById(R.id.image_viewer_reply);
        this.fpI.setText(R.string.image_viewer_reply);
        ap.setViewTextColor(this.fpI, R.color.CAM_X0101);
        this.fpI.setBackground(ap.aR(l.getDimens(context, R.dimen.tbds38), ap.getColor(R.color.CAM_X0615)));
        this.fpJ = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        this.fcH = (ImageView) findViewById(R.id.comment_icon);
        WebPManager.a(this.fcH, R.drawable.icon_pure_card_comment22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        this.eBF = (TextView) findViewById(R.id.comment_num);
        this.eBF.setText("0");
        this.fcF = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.fcF.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
        this.fcF.setIsFromBigpic(true);
        this.fcF.setAgreeAlone(true);
        this.fcF.setAgreeAnimationResource();
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.fcF.getImgAgree().setAlpha(0.83f);
        } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            this.fcF.getImgAgree().setAlpha(0.92f);
        } else {
            this.fcF.getImgAgree().setAlpha(1.0f);
        }
        d dVar = new d();
        dVar.eEJ = 13;
        dVar.eEP = 10;
        this.fcF.setStatisticData(dVar);
        this.fcK = (ImageView) findViewById(R.id.share_icon);
        WebPManager.a(this.fcK, R.drawable.icon_pure_card_share22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        this.fpK = (ImageView) findViewById(R.id.download_icon);
        WebPManager.a(this.fpK, R.drawable.icon_pure_share_download22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
    }

    public void setExpandButtonListener(a aVar) {
        this.fpC = aVar;
    }

    public void setOnShareImageListener(c cVar) {
        this.fpL = cVar;
    }

    public void setOnDownloadImageListener(b bVar) {
        this.fpM = bVar;
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        this.fpI.setOnClickListener(onClickListener);
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.foq = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.eBF.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.fcF.setData(imageUrlData.agreeData);
            }
            this.fpH.setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    private void initListener() {
        this.fcH.setOnClickListener(this);
        this.eBF.setOnClickListener(this);
        this.fcK.setOnClickListener(this);
        this.fpK.setOnClickListener(this);
        this.fpH.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void kf(boolean z) {
        if (z) {
            this.fpF.setText(getContext().getString(R.string.expand));
            SvgManager.btW().a(this.fpG, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
            this.fpJ.setVisibility(8);
            this.fpI.setVisibility(8);
            return;
        }
        this.fpF.setText(getContext().getString(R.string.fold));
        SvgManager.btW().a(this.fpG, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        this.fpJ.setVisibility(0);
        this.fpI.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fcH || view == this.eBF) {
            if (this.foq != null) {
                ar arVar = new ar("c13685");
                arVar.w("tid", this.foq.threadId);
                arVar.dY("nid", this.foq.nid);
                arVar.dY("fid", this.foq.forumId);
                if (this.foq.from == "index") {
                    arVar.al("obj_locate", 1);
                } else if (this.foq.from == "frs") {
                    arVar.al("obj_locate", 2);
                } else if (this.foq.from == "pb") {
                    arVar.al("obj_locate", 3);
                }
                TiebaStatic.log(arVar);
            }
            com.baidu.tbadk.pageExtra.c bM = com.baidu.tbadk.pageExtra.d.bM(view);
            ar arVar2 = new ar("c12942");
            arVar2.dY("obj_type", "2");
            arVar2.dY("obj_locate", "12");
            if (bM != null) {
                arVar2.dY("obj_cur_page", bM.getCurrentPageKey());
            }
            if (com.baidu.tbadk.pageExtra.d.bET() != null) {
                arVar2.dY("obj_pre_page", com.baidu.tbadk.pageExtra.d.bET());
            }
            TiebaStatic.log(arVar2);
            bAr();
        } else if (view == this.fcK) {
            if (this.fpL != null) {
                this.fpL.bAC();
            }
            if (this.foq != null) {
                TiebaStatic.log(new ar("c13857").dY("obj_type", "1").w("post_id", this.foq.threadId).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", this.foq.forumId));
            }
        } else if (view == this.fpK) {
            if (this.fpM != null) {
                this.fpM.bAB();
            }
            if (this.foq != null) {
                TiebaStatic.log(new ar("c13857").dY("obj_type", "2").w("post_id", this.foq.threadId).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", this.foq.forumId));
            }
        } else if (view == this.fpH) {
            if (this.fpF.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.fpF.setText(getContext().getString(R.string.fold));
                SvgManager.btW().a(this.fpG, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
                if (this.fpC != null) {
                    this.fpC.a(this, true);
                }
            } else {
                this.fpF.setText(getContext().getString(R.string.expand));
                SvgManager.btW().a(this.fpG, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
                if (this.fpC != null) {
                    this.fpC.a(this, false);
                }
            }
            TiebaStatic.log(new ar("c13857").dY("obj_type", "6").w("post_id", this.foq.threadId).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", this.foq.forumId));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new ar("c13339").dY("uid", this.mUserId).w("post_id", this.foq.threadId));
        return true;
    }

    private void bAr() {
        if (this.foq != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.foq.threadId), String.valueOf(this.foq.postId), this.foq.mIsSeeHost, this.foq.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
