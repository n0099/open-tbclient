package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel bmW;
    private RecommendForumInfo dWH;
    private ForumDetailActivity dWN;
    private ViewGroup dXa;
    private TextView dXb;
    private ImageView dXc;
    private ViewGroup dXd;
    private View dXe;
    private boolean dXf;
    private com.baidu.tbadk.core.dialog.a dXg;
    private AntiHelper.a dqz;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.dXf = false;
        this.dqz = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.ajh));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.ajh));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dXf = false;
        this.dqz = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.ajh));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.ajh));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.i.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.dXa = (ViewGroup) findViewById(d.g.fn_care_box);
        this.dXb = (TextView) findViewById(d.g.fn_care_btn);
        this.dXc = (ImageView) findViewById(d.g.icon_brief_care);
        this.dXd = (ViewGroup) findViewById(d.g.fn_enter_box);
        this.dXe = findViewById(d.g.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.dWN = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.dXf = forumDetailActivity.getIntent().getStringExtra("from_type").equals(ForumDetailActivityConfig.FromType.FRS.toString());
            this.dWH = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            ha(recommendForumInfo.is_like.intValue() == 1);
            this.dXa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.dXd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.dXf) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.rG())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.dWN.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.dXa.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.dXf);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.rG())) {
                    TiebaStatic.eventStat(this.dWN.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.dXf);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gZ(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(d.g.attention_icon);
        TextView textView = (TextView) inflate.findViewById(d.g.attention_title);
        ak.h(textView, d.C0126d.cp_cont_g);
        if (z) {
            imageView.setImageDrawable(ak.getDrawable(d.f.icon_tips_attention_ok));
            textView.setText(d.k.attention);
        } else {
            imageView.setImageDrawable(ak.getDrawable(d.f.icon_tips_attention_cancel));
            textView.setText(d.k.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.dWN.gW(true);
        } else {
            this.dWN.gW(false);
        }
        this.dWN.setSwitch(z);
        this.dWN.gX(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.bmW == null) {
            this.bmW = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.bmW.setFrom("detail_follow");
        this.bmW.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (ItemFootNavView.this.bmW.getErrorCode() == 22) {
                    ItemFootNavView.this.gZ(true);
                    ItemFootNavView.this.ha(true);
                } else if (!AntiHelper.tt(ItemFootNavView.this.bmW.getErrorCode())) {
                    if (ItemFootNavView.this.bmW.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.bmW.getErrorString());
                        return;
                    }
                    r rVar = (r) obj;
                    if (rVar != null) {
                        ItemFootNavView.this.gZ(true);
                        TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.dWH.forum_name);
                        ItemFootNavView.this.ha(true);
                        rVar.setLike(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                        return;
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(d.k.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.bmW.getBlockPopInfoData(), ItemFootNavView.this.dqz) != null) {
                    TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.ajh));
                }
            }
        });
        this.bmW.cb(this.dWH.forum_name, String.valueOf(this.dWH.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.dXg == null) {
            this.dXg = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.dXg.bZ(d.k.forum_info_unlike_msg);
            this.dXg.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.dXg.dismiss();
                    w wVar = new w();
                    wVar.setFrom("bar_detail");
                    wVar.a(new w.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void m(String str, long j) {
                            ItemFootNavView.this.gZ(false);
                            ItemFootNavView.this.ha(false);
                            if (ItemFootNavView.this.dWH != null && ItemFootNavView.this.dWH.forum_id.longValue() != 0) {
                                r rVar = new r();
                                rVar.setFid(j + "");
                                rVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.dWH.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void n(String str, long j) {
                            baseActivity.showToast(baseActivity.getPageContext().getString(d.k.unlike_failure));
                        }
                    });
                    wVar.t(ItemFootNavView.this.dWH.forum_name, ItemFootNavView.this.dWH.forum_id.longValue());
                }
            });
            this.dXg.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.dXg.dismiss();
                }
            });
            this.dXg.as(true);
        }
        this.dXg.b(baseActivity.getPageContext()).tD();
    }

    public void ha(boolean z) {
        int i;
        if (z) {
            ak.c(this.dXc, d.f.icon_pop_pass);
            i = d.k.relate_forum_is_followed;
            this.dXa.setTag(0);
        } else {
            ak.c(this.dXc, d.f.icon_brief_attention);
            i = d.k.attention;
            this.dXa.setTag(1);
        }
        this.dXb.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().u(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void hb(boolean z) {
        if (z) {
            this.dXe.setVisibility(0);
        } else {
            this.dXe.setVisibility(8);
        }
    }
}
