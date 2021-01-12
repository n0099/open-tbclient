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
    public static final int fuD = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private TextView eGx;
    private AgreeView fhD;
    private ImageView fhF;
    private ImageView fhI;
    private ImageUrlData ftr;
    private a fuB;
    private TextView fuE;
    private ImageView fuF;
    private View fuG;
    private TextView fuH;
    private LinearLayout fuI;
    private ImageView fuJ;
    private c fuK;
    private b fuL;
    private Context mContext;
    private String mUserId;

    /* loaded from: classes.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bzc();
    }

    /* loaded from: classes.dex */
    public interface c {
        void bzd();
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.fuB = null;
        this.fuK = null;
        this.fuL = null;
        this.mContext = context;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.fuG = findViewById(R.id.unfold_root);
        this.fuE = (TextView) findViewById(R.id.unfold_text);
        this.fuF = (ImageView) findViewById(R.id.unfold_icon);
        this.fuG.setVisibility(8);
        WebPManager.a(this.fuF, R.drawable.icon_mask_unfold30, (WebPManager.ResourceStateType) null);
        this.fuH = (TextView) findViewById(R.id.image_viewer_reply);
        this.fuH.setText(R.string.image_viewer_reply);
        ao.setViewTextColor(this.fuH, R.color.CAM_X0101);
        this.fuH.setBackground(ao.aO(l.getDimens(context, R.dimen.tbds38), ao.getColor(R.color.CAM_X0615)));
        this.fuI = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        this.fhF = (ImageView) findViewById(R.id.comment_icon);
        WebPManager.a(this.fhF, R.drawable.icon_pure_card_comment22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        this.eGx = (TextView) findViewById(R.id.comment_num);
        this.eGx.setText("0");
        this.fhD = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.fhD.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
        this.fhD.setIsFromBigpic(true);
        this.fhD.setAgreeAlone(true);
        this.fhD.setAgreeAnimationResource();
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.fhD.getImgAgree().setAlpha(0.83f);
        } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            this.fhD.getImgAgree().setAlpha(0.92f);
        } else {
            this.fhD.getImgAgree().setAlpha(1.0f);
        }
        d dVar = new d();
        dVar.eJO = 13;
        dVar.eJU = 10;
        this.fhD.setStatisticData(dVar);
        this.fhI = (ImageView) findViewById(R.id.share_icon);
        WebPManager.a(this.fhI, R.drawable.icon_pure_expression22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        this.fuJ = (ImageView) findViewById(R.id.download_icon);
        WebPManager.a(this.fuJ, R.drawable.icon_pure_share_download22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
    }

    public void setExpandButtonListener(a aVar) {
        this.fuB = aVar;
    }

    public void setOnShareImageListener(c cVar) {
        this.fuK = cVar;
    }

    public void setOnDownloadImageListener(b bVar) {
        this.fuL = bVar;
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        this.fuH.setOnClickListener(onClickListener);
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.ftr = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.eGx.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.fhD.setData(imageUrlData.agreeData);
            }
            this.fuG.setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    private void initListener() {
        this.fhF.setOnClickListener(this);
        this.eGx.setOnClickListener(this);
        this.fhI.setOnClickListener(this);
        this.fuJ.setOnClickListener(this);
        this.fuG.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void kx(boolean z) {
        if (z) {
            this.fuE.setText(getContext().getString(R.string.expand));
            WebPManager.a(this.fuF, R.drawable.icon_mask_fold30, (WebPManager.ResourceStateType) null);
            this.fuI.setVisibility(8);
            this.fuH.setVisibility(8);
            return;
        }
        this.fuE.setText(getContext().getString(R.string.fold));
        WebPManager.a(this.fuF, R.drawable.icon_mask_unfold30, (WebPManager.ResourceStateType) null);
        this.fuI.setVisibility(0);
        this.fuH.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fhF || view == this.eGx) {
            if (this.ftr != null) {
                aq aqVar = new aq("c13685");
                aqVar.w("tid", this.ftr.threadId);
                aqVar.dW(IntentConfig.NID, this.ftr.nid);
                aqVar.dW("fid", this.ftr.forumId);
                if (this.ftr.from == "index") {
                    aqVar.an("obj_locate", 1);
                } else if (this.ftr.from == "frs") {
                    aqVar.an("obj_locate", 2);
                } else if (this.ftr.from == "pb") {
                    aqVar.an("obj_locate", 3);
                }
                TiebaStatic.log(aqVar);
            }
            com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(view);
            aq aqVar2 = new aq("c12942");
            aqVar2.dW("obj_type", "2");
            aqVar2.dW("obj_locate", Constants.VIA_REPORT_TYPE_SET_AVATAR);
            if (bV != null) {
                aqVar2.dW("obj_cur_page", bV.getCurrentPageKey());
            }
            if (com.baidu.tbadk.pageExtra.d.bDu() != null) {
                aqVar2.dW("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDu());
            }
            TiebaStatic.log(aqVar2);
            byS();
        } else if (view == this.fhI) {
            if (this.fuK != null) {
                this.fuK.bzd();
            }
            if (this.ftr != null) {
                TiebaStatic.log(new aq("c13857").dW("obj_type", "9").w("post_id", this.ftr.threadId).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("fid", this.ftr.forumId));
            }
        } else if (view == this.fuJ) {
            if (this.fuL != null) {
                this.fuL.bzc();
            }
            if (this.ftr != null) {
                TiebaStatic.log(new aq("c13857").dW("obj_type", "2").w("post_id", this.ftr.threadId).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("fid", this.ftr.forumId));
            }
        } else if (view == this.fuG) {
            if (this.fuE.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.fuE.setText(getContext().getString(R.string.fold));
                WebPManager.a(this.fuF, R.drawable.icon_mask_unfold30, (WebPManager.ResourceStateType) null);
                if (this.fuB != null) {
                    this.fuB.a(this, true);
                }
            } else {
                this.fuE.setText(getContext().getString(R.string.expand));
                WebPManager.a(this.fuF, R.drawable.icon_mask_fold30, (WebPManager.ResourceStateType) null);
                if (this.fuB != null) {
                    this.fuB.a(this, false);
                }
            }
            TiebaStatic.log(new aq("c13857").dW("obj_type", "6").w("post_id", this.ftr.threadId).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("fid", this.ftr.forumId));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new aq("c13339").dW("uid", this.mUserId).w("post_id", this.ftr.threadId));
        return true;
    }

    private void byS() {
        if (this.ftr != null) {
            String valueOf = String.valueOf(this.ftr.threadId);
            String valueOf2 = String.valueOf(this.ftr.postId);
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(valueOf, valueOf2, this.ftr.mIsSeeHost, this.ftr.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            createHistoryCfg.setHighLightPostId(valueOf2);
            createHistoryCfg.setStartFrom(23);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
