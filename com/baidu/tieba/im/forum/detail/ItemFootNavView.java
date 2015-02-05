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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.z;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class ItemFootNavView extends LinearLayout {
    private ForumDetailActivity baB;
    private ViewGroup baN;
    private TextView baO;
    private ImageView baP;
    private ViewGroup baQ;
    private View baR;
    private boolean baS;
    private View baT;
    private com.baidu.tbadk.core.dialog.a baU;
    private RecommendForumInfo bay;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.baS = false;
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baS = false;
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.forum_detail_foot_nav, this, true);
        setOrientation(1);
        setVisibility(8);
        this.baN = (ViewGroup) findViewById(com.baidu.tieba.w.fn_care_box);
        this.baO = (TextView) findViewById(com.baidu.tieba.w.fn_care_btn);
        this.baP = (ImageView) findViewById(com.baidu.tieba.w.icon_brief_care);
        this.baQ = (ViewGroup) findViewById(com.baidu.tieba.w.fn_enter_box);
        this.baR = findViewById(com.baidu.tieba.w.foot_line);
    }

    public void a(RecommendForumInfo recommendForumInfo, ForumDetailActivity forumDetailActivity) {
        this.baB = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.baS = forumDetailActivity.getIntent().getStringExtra(ForumDetailActivityConfig.FROM_TYPE).equals(ForumDetailActivityConfig.FromType.FRS.toString());
            this.bay = recommendForumInfo;
            String str = recommendForumInfo.forum_name;
            cR(recommendForumInfo.is_like.intValue() == 1);
            this.baN.setOnClickListener(new q(this, forumDetailActivity));
            this.baQ.setOnClickListener(new r(this, forumDetailActivity, str));
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        boolean z = (TbadkCoreApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccountName() == null) ? false : true;
        Object tag = this.baO.getTag();
        boolean z2 = (tag == null || ((Integer) tag).intValue() != 2) ? true : true;
        if (!z && !z2) {
            this.baO.setTag(2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) forumDetailActivity.getPageContext().getPageActivity(), getResources().getString(z.login_to_use), true, 11034)));
            return;
        }
        this.baO.setTag(3);
        int intValue = ((Integer) this.baN.getTag()).intValue();
        if (intValue == 0) {
            a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.baS);
        } else if (intValue == 1) {
            a(forumDetailActivity, this.baS);
        }
        TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(boolean z) {
        if (this.baT == null) {
            this.baT = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.forum_detail_attention_toast, null);
        }
        ImageView imageView = (ImageView) this.baT.findViewById(com.baidu.tieba.w.attention_icon);
        TextView textView = (TextView) this.baT.findViewById(com.baidu.tieba.w.attention_title);
        if (z) {
            imageView.setImageDrawable(bc.getDrawable(com.baidu.tieba.v.icon_tips_attention_ok));
            textView.setText(z.attention_n);
        } else {
            imageView.setImageDrawable(bc.getDrawable(com.baidu.tieba.v.icon_tips_attention_cancel));
            textView.setText(z.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(this.baT);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.baB.cO(true);
        } else {
            this.baB.cO(false);
        }
        this.baB.setSwitch(z);
        this.baB.cP(z);
    }

    private void a(ForumDetailActivity forumDetailActivity, boolean z) {
        ac acVar = new ac(forumDetailActivity.getPageContext());
        acVar.setFrom("detail_follow");
        acVar.setLoadDataCallBack(new s(this, acVar, forumDetailActivity));
        acVar.aQ(this.bay.forum_name, String.valueOf(this.bay.forum_id));
    }

    private void a(BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.baU == null) {
            this.baU = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.baU.by(z.forum_info_unlike_msg);
            this.baU.a(z.alert_yes_button, new t(this, baseActivity));
            this.baU.b(z.alert_no_button, new v(this));
            this.baU.ai(true);
        }
        this.baU.b(baseActivity.getPageContext()).nQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR(boolean z) {
        int i;
        if (z) {
            bc.c(this.baP, com.baidu.tieba.v.icon_pop_pass);
            i = z.followed_title;
            this.baN.setTag(0);
        } else {
            bc.c(this.baP, com.baidu.tieba.v.icon_brief_attention);
            i = z.attention;
            this.baN.setTag(1);
        }
        this.baO.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().ab(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
        Object tag;
        if (this.baO != null && (tag = this.baO.getTag()) != null && ((Integer) tag).intValue() == 2) {
            d(forumDetailActivity);
        }
    }

    public void cS(boolean z) {
        if (z) {
            this.baR.setVisibility(0);
        } else {
            this.baR.setVisibility(8);
        }
    }
}
