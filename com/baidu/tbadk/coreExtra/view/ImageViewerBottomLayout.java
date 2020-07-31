package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int evR = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private TextView dKx;
    private AgreeView ejB;
    private ImageView ejC;
    private ImageView ejF;
    private ImageUrlData euE;
    private a evP;
    private TextView evS;
    private ImageView evT;
    private View evU;
    private LinearLayout evV;
    private ImageView evW;
    private c evX;
    private b evY;
    private String mUserId;

    /* loaded from: classes15.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes15.dex */
    public interface b {
        void bhc();
    }

    /* loaded from: classes15.dex */
    public interface c {
        void bhd();
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.evP = null;
        this.evX = null;
        this.evY = null;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.evU = findViewById(R.id.unfold_root);
        this.evS = (TextView) findViewById(R.id.unfold_text);
        this.evT = (ImageView) findViewById(R.id.unfold_icon);
        this.evU.setVisibility(8);
        SvgManager.baR().a(this.evT, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.evV = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        this.ejC = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.baR().a(this.ejC, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dKx = (TextView) findViewById(R.id.comment_num);
        this.dKx.setText("0");
        this.ejB = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.ejB.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
        this.ejB.setIsFromBigpic(true);
        this.ejB.setAgreeAlone(true);
        this.ejB.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = 13;
        cVar.dNH = 10;
        this.ejB.setStatisticData(cVar);
        this.ejF = (ImageView) findViewById(R.id.share_icon);
        SvgManager.baR().a(this.ejF, R.drawable.ic_icon_pure_share24, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.evW = (ImageView) findViewById(R.id.download_icon);
        SvgManager.baR().a(this.evW, R.drawable.ic_icon_pure_download24, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
    }

    public void setExpandButtonListener(a aVar) {
        this.evP = aVar;
    }

    public void setOnShareImageListener(c cVar) {
        this.evX = cVar;
    }

    public void setOnDownloadImageListener(b bVar) {
        this.evY = bVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.euE = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.dKx.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.ejB.setData(imageUrlData.agreeData);
            }
            if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.evU.setVisibility(4);
                return;
            } else {
                this.evU.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.ejC.setOnClickListener(this);
        this.dKx.setOnClickListener(this);
        this.ejF.setOnClickListener(this);
        this.evW.setOnClickListener(this);
        this.evU.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void ix(boolean z) {
        if (z) {
            this.evS.setText(getContext().getString(R.string.expand));
            SvgManager.baR().a(this.evT, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.evV.setVisibility(8);
            return;
        }
        this.evS.setText(getContext().getString(R.string.fold));
        SvgManager.baR().a(this.evT, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.evV.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ejC || view == this.dKx) {
            if (this.euE != null) {
                ap apVar = new ap("c13685");
                apVar.t("tid", this.euE.threadId);
                apVar.dn("nid", this.euE.nid);
                apVar.dn("fid", this.euE.forumId);
                if (this.euE.from == "index") {
                    apVar.ah("obj_locate", 1);
                } else if (this.euE.from == "frs") {
                    apVar.ah("obj_locate", 2);
                } else if (this.euE.from == "pb") {
                    apVar.ah("obj_locate", 3);
                }
                TiebaStatic.log(apVar);
            }
            TiebaStatic.log(new ap("c12942").dn("obj_type", "2").dn("obj_locate", "12"));
            bgS();
        } else if (view == this.ejF) {
            if (this.evX != null) {
                this.evX.bhd();
            }
            if (this.euE != null) {
                TiebaStatic.log(new ap("c13857").dn("obj_type", "1").t("post_id", this.euE.threadId).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("fid", this.euE.forumId));
            }
        } else if (view == this.evW) {
            if (this.evY != null) {
                this.evY.bhc();
            }
            if (this.euE != null) {
                TiebaStatic.log(new ap("c13857").dn("obj_type", "2").t("post_id", this.euE.threadId).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("fid", this.euE.forumId));
            }
        } else if (view == this.evU) {
            if (this.evS.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.evS.setText(getContext().getString(R.string.fold));
                SvgManager.baR().a(this.evT, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.evP != null) {
                    this.evP.a(this, true);
                    return;
                }
                return;
            }
            this.evS.setText(getContext().getString(R.string.expand));
            SvgManager.baR().a(this.evT, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            if (this.evP != null) {
                this.evP.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new ap("c13339").dn("uid", this.mUserId).t("post_id", this.euE.threadId));
        return true;
    }

    private void bgS() {
        if (this.euE != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.euE.threadId), String.valueOf(this.euE.postId), this.euE.mIsSeeHost, this.euE.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
