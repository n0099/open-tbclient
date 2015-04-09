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
    private RecommendForumInfo bcQ;
    private ForumDetailActivity bcU;
    private ViewGroup bdg;
    private TextView bdh;
    private ImageView bdi;
    private ViewGroup bdj;
    private View bdk;
    private boolean bdl;
    private com.baidu.tbadk.core.dialog.a bdm;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.bdl = false;
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdl = false;
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.forum_detail_foot_nav, this, true);
        setOrientation(1);
        setVisibility(8);
        this.bdg = (ViewGroup) findViewById(com.baidu.tieba.v.fn_care_box);
        this.bdh = (TextView) findViewById(com.baidu.tieba.v.fn_care_btn);
        this.bdi = (ImageView) findViewById(com.baidu.tieba.v.icon_brief_care);
        this.bdj = (ViewGroup) findViewById(com.baidu.tieba.v.fn_enter_box);
        this.bdk = findViewById(com.baidu.tieba.v.foot_line);
    }

    public void a(RecommendForumInfo recommendForumInfo, ForumDetailActivity forumDetailActivity) {
        this.bcU = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.bdl = forumDetailActivity.getIntent().getStringExtra(ForumDetailActivityConfig.FROM_TYPE).equals(ForumDetailActivityConfig.FromType.FRS.toString());
            this.bcQ = recommendForumInfo;
            String str = recommendForumInfo.forum_name;
            cD(recommendForumInfo.is_like.intValue() == 1);
            this.bdg.setOnClickListener(new q(this, forumDetailActivity));
            this.bdj.setOnClickListener(new r(this, forumDetailActivity, str));
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        boolean z = (TbadkCoreApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccountName() == null) ? false : true;
        Object tag = this.bdh.getTag();
        boolean z2 = (tag == null || ((Integer) tag).intValue() != 2) ? true : true;
        if (!z && !z2) {
            this.bdh.setTag(2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) forumDetailActivity.getPageContext().getPageActivity(), getResources().getString(com.baidu.tieba.y.login_to_use), true, 11034)));
            return;
        }
        this.bdh.setTag(3);
        int intValue = ((Integer) this.bdg.getTag()).intValue();
        if (intValue == 0) {
            a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.bdl);
        } else if (intValue == 1) {
            if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.Qr())) {
                TiebaStatic.eventStat(this.bcU.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
            }
            a(forumDetailActivity, this.bdl);
        }
        TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(boolean z) {
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
            this.bcU.cA(true);
        } else {
            this.bcU.cA(false);
        }
        this.bcU.setSwitch(z);
        this.bcU.cB(z);
    }

    private void a(ForumDetailActivity forumDetailActivity, boolean z) {
        af afVar = new af(forumDetailActivity.getPageContext());
        afVar.setFrom("detail_follow");
        afVar.setLoadDataCallBack(new s(this, afVar, forumDetailActivity));
        afVar.aV(this.bcQ.forum_name, String.valueOf(this.bcQ.forum_id));
    }

    private void a(BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.bdm == null) {
            this.bdm = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.bdm.bx(com.baidu.tieba.y.forum_info_unlike_msg);
            this.bdm.a(com.baidu.tieba.y.alert_yes_button, new t(this, baseActivity));
            this.bdm.b(com.baidu.tieba.y.alert_no_button, new v(this));
            this.bdm.ad(true);
        }
        this.bdm.b(baseActivity.getPageContext()).re();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(boolean z) {
        int i;
        if (z) {
            ba.c(this.bdi, com.baidu.tieba.u.icon_pop_pass);
            i = com.baidu.tieba.y.followed_title;
            this.bdg.setTag(0);
        } else {
            ba.c(this.bdi, com.baidu.tieba.u.icon_brief_attention);
            i = com.baidu.tieba.y.attention;
            this.bdg.setTag(1);
        }
        this.bdh.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().X(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
        Object tag;
        if (this.bdh != null && (tag = this.bdh.getTag()) != null && ((Integer) tag).intValue() == 2) {
            d(forumDetailActivity);
        }
    }

    public void cE(boolean z) {
        if (z) {
            this.bdk.setVisibility(0);
        } else {
            this.bdk.setVisibility(8);
        }
    }
}
