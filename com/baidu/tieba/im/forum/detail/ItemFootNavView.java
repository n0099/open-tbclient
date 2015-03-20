package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.tbadkCore.af;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class ItemFootNavView extends LinearLayout {
    private RecommendForumInfo bcA;
    private ForumDetailActivity bcE;
    private ViewGroup bcQ;
    private TextView bcR;
    private ImageView bcS;
    private ViewGroup bcT;
    private View bcU;
    private boolean bcV;
    private com.baidu.tbadk.core.dialog.a bcW;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.bcV = false;
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcV = false;
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.forum_detail_foot_nav, this, true);
        setOrientation(1);
        setVisibility(8);
        this.bcQ = (ViewGroup) findViewById(com.baidu.tieba.v.fn_care_box);
        this.bcR = (TextView) findViewById(com.baidu.tieba.v.fn_care_btn);
        this.bcS = (ImageView) findViewById(com.baidu.tieba.v.icon_brief_care);
        this.bcT = (ViewGroup) findViewById(com.baidu.tieba.v.fn_enter_box);
        this.bcU = findViewById(com.baidu.tieba.v.foot_line);
    }

    public void a(RecommendForumInfo recommendForumInfo, ForumDetailActivity forumDetailActivity) {
        this.bcE = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.bcV = forumDetailActivity.getIntent().getStringExtra(ForumDetailActivityConfig.FROM_TYPE).equals(ForumDetailActivityConfig.FromType.FRS.toString());
            this.bcA = recommendForumInfo;
            String str = recommendForumInfo.forum_name;
            cF(recommendForumInfo.is_like.intValue() == 1);
            this.bcQ.setOnClickListener(new q(this, forumDetailActivity));
            this.bcT.setOnClickListener(new r(this, forumDetailActivity, str));
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        boolean z = (TbadkCoreApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccountName() == null) ? false : true;
        Object tag = this.bcR.getTag();
        boolean z2 = (tag == null || ((Integer) tag).intValue() != 2) ? true : true;
        if (!z && !z2) {
            this.bcR.setTag(2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) forumDetailActivity.getPageContext().getPageActivity(), getResources().getString(com.baidu.tieba.y.login_to_use), true, 11034)));
            return;
        }
        this.bcR.setTag(3);
        int intValue = ((Integer) this.bcQ.getTag()).intValue();
        if (intValue == 0) {
            a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.bcV);
        } else if (intValue == 1) {
            if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.Qe())) {
                TiebaStatic.eventStat(this.bcE.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
            }
            a(forumDetailActivity, this.bcV);
        }
        TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(boolean z) {
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.forum_detail_attention_toast, null);
        ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.v.attention_icon);
        TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.attention_title);
        if (z) {
            imageView.setImageDrawable(ba.getDrawable(com.baidu.tieba.u.icon_tips_attention_ok));
            textView.setText(com.baidu.tieba.y.attention_n);
        } else {
            imageView.setImageDrawable(ba.getDrawable(com.baidu.tieba.u.icon_tips_attention_cancel));
            textView.setText(com.baidu.tieba.y.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.bcE.cC(true);
        } else {
            this.bcE.cC(false);
        }
        this.bcE.setSwitch(z);
        this.bcE.cD(z);
    }

    private void a(ForumDetailActivity forumDetailActivity, boolean z) {
        af afVar = new af(forumDetailActivity.getPageContext());
        afVar.setFrom("detail_follow");
        afVar.setLoadDataCallBack(new s(this, afVar, forumDetailActivity));
        afVar.aV(this.bcA.forum_name, String.valueOf(this.bcA.forum_id));
    }

    private void a(BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.bcW == null) {
            this.bcW = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.bcW.bx(com.baidu.tieba.y.forum_info_unlike_msg);
            this.bcW.a(com.baidu.tieba.y.alert_yes_button, new t(this, baseActivity));
            this.bcW.b(com.baidu.tieba.y.alert_no_button, new v(this));
            this.bcW.ad(true);
        }
        this.bcW.b(baseActivity.getPageContext()).re();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(boolean z) {
        int i;
        if (z) {
            ba.c(this.bcS, com.baidu.tieba.u.icon_pop_pass);
            i = com.baidu.tieba.y.followed_title;
            this.bcQ.setTag(0);
        } else {
            ba.c(this.bcS, com.baidu.tieba.u.icon_brief_attention);
            i = com.baidu.tieba.y.attention;
            this.bcQ.setTag(1);
        }
        this.bcR.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().X(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
        Object tag;
        if (this.bcR != null && (tag = this.bcR.getTag()) != null && ((Integer) tag).intValue() == 2) {
            d(forumDetailActivity);
        }
    }

    public void cG(boolean z) {
        if (z) {
            this.bcU.setVisibility(0);
        } else {
            this.bcU.setVisibility(8);
        }
    }
}
