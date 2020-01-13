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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int dnX = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView dda;
    private TextView ddb;
    private ImageView ddc;
    private ImageUrlData dmy;
    private a dnV;
    private TextView dnY;
    private ImageView dnZ;
    private View doa;
    private boolean dob;
    private String mUserId;

    /* loaded from: classes6.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.dnV = null;
        this.dob = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.dnV = null;
        this.dob = true;
        this.dob = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.doa = findViewById(R.id.unfold_root);
        this.dnY = (TextView) findViewById(R.id.unfold_text);
        this.dnZ = (ImageView) findViewById(R.id.unfold_icon);
        this.doa.setVisibility(8);
        SvgManager.aEp().a(this.dnZ, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.ddc = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.aEp().a(this.ddc, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.ddb = (TextView) findViewById(R.id.comment_num);
        this.ddb.setText("0");
        this.dda = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.dda.setIsFromBigpic(true);
        this.dda.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = 13;
        dVar.cJD = 10;
        this.dda.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.dnV = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.dda != null) {
            this.dda.setAgreeAlone(z);
        }
    }

    public void b(ImageUrlData imageUrlData) {
        this.dmy = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.ddb.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.dda.setData(imageUrlData.agreeData);
            }
            if (!this.dob) {
                this.doa.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.doa.setVisibility(4);
                return;
            } else {
                this.doa.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.ddc.setOnClickListener(this);
        this.ddb.setOnClickListener(this);
        this.doa.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void gi(boolean z) {
        if (z) {
            this.dnY.setText(getContext().getString(R.string.expand));
            SvgManager.aEp().a(this.dnZ, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            return;
        }
        this.dnY.setText(getContext().getString(R.string.fold));
        SvgManager.aEp().a(this.dnZ, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ddc || view == this.ddb) {
            TiebaStatic.log(new an("c12942").cp("obj_type", "2").cp("obj_locate", "12"));
            aKa();
        } else if (view == this.doa) {
            if (this.dnY.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.dnY.setText(getContext().getString(R.string.fold));
                SvgManager.aEp().a(this.dnZ, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.dnV != null) {
                    this.dnV.a(this, true);
                    return;
                }
                return;
            }
            this.dnY.setText(getContext().getString(R.string.expand));
            SvgManager.aEp().a(this.dnZ, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            if (this.dnV != null) {
                this.dnV.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new an("c13339").cp("uid", this.mUserId).s("post_id", this.dmy.threadId));
        return true;
    }

    private void aKa() {
        if (this.dmy != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.dmy.threadId), String.valueOf(this.dmy.postId), this.dmy.mIsSeeHost, this.dmy.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
