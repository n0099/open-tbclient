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
import com.baidu.adp.base.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel aLl;
    private RecommendForumInfo eNU;
    private ForumDetailActivity eOa;
    private ViewGroup eOn;
    private TextView eOo;
    private ImageView eOp;
    private ViewGroup eOq;
    private View eOr;
    private boolean eOs;
    private com.baidu.tbadk.core.dialog.a eOt;
    private AntiHelper.a edy;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.eOs = false;
        this.edy = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCQ));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCQ));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eOs = false;
        this.edy = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCQ));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCQ));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.eOn = (ViewGroup) findViewById(e.g.fn_care_box);
        this.eOo = (TextView) findViewById(e.g.fn_care_btn);
        this.eOp = (ImageView) findViewById(e.g.icon_brief_care);
        this.eOq = (ViewGroup) findViewById(e.g.fn_enter_box);
        this.eOr = findViewById(e.g.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.eOa = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.eOs = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.eNU = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            iw(recommendForumInfo.is_like.intValue() == 1);
            this.eOn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.eOq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    if (ItemFootNavView.this.eOs) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.zu())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.eOa.getPageContext().getPageActivity(), "squae_introduce_entry", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.eOn.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.eOs);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.zu())) {
                    TiebaStatic.eventStat(this.eOa.getPageContext().getPageActivity(), "squae_introduce_focus", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                a(forumDetailActivity, this.eOs);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iv(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(e.g.attention_icon);
        TextView textView = (TextView) inflate.findViewById(e.g.attention_title);
        al.h(textView, e.d.cp_cont_g);
        if (z) {
            imageView.setImageDrawable(al.getDrawable(e.f.icon_tips_attention_ok));
            textView.setText(e.j.attention);
        } else {
            imageView.setImageDrawable(al.getDrawable(e.f.icon_tips_attention_cancel));
            textView.setText(e.j.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.eOa.is(true);
        } else {
            this.eOa.is(false);
        }
        this.eOa.setSwitch(z);
        this.eOa.it(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.aLl == null) {
            this.aLl = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.aLl.setFrom("detail_follow");
        this.aLl.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (ItemFootNavView.this.aLl.getErrorCode() == 22) {
                    ItemFootNavView.this.iv(true);
                    ItemFootNavView.this.iw(true);
                } else if (!AntiHelper.ai(ItemFootNavView.this.aLl.getErrorCode(), ItemFootNavView.this.aLl.getErrorString())) {
                    if (ItemFootNavView.this.aLl.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.aLl.getErrorString());
                        return;
                    }
                    r rVar = (r) obj;
                    if (rVar != null) {
                        if (rVar.getErrorCode() == 3250013) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).BN();
                            return;
                        } else if (!AntiHelper.vA(rVar.getErrorCode())) {
                            ItemFootNavView.this.iv(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.eNU.forum_name);
                            ItemFootNavView.this.iw(true);
                            rVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.aLl.getBlockPopInfoData(), ItemFootNavView.this.edy);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(e.j.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.aLl.getBlockPopInfoData(), ItemFootNavView.this.edy) != null) {
                    TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCQ));
                }
            }
        });
        this.aLl.cK(this.eNU.forum_name, String.valueOf(this.eNU.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.eOt == null) {
            this.eOt = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.eOt.db(e.j.forum_info_unlike_msg);
            this.eOt.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.eOt.dismiss();
                    w wVar = new w();
                    wVar.setFrom("bar_detail");
                    wVar.a(new w.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void p(String str, long j) {
                            ItemFootNavView.this.iv(false);
                            ItemFootNavView.this.iw(false);
                            if (ItemFootNavView.this.eNU != null && ItemFootNavView.this.eNU.forum_id.longValue() != 0) {
                                r rVar = new r();
                                rVar.setFid(j + "");
                                rVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.eNU.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void q(String str, long j) {
                            if (j == 3250013) {
                                if (ao.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(e.j.anti_account_exception_appealing);
                                }
                                BdToast.a(TbadkCoreApplication.getInst().getContext(), str, e.f.icon_toast_game_error, 3000).BN();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(e.j.unlike_failure));
                        }
                    });
                    wVar.w(ItemFootNavView.this.eNU.forum_name, ItemFootNavView.this.eNU.forum_id.longValue());
                }
            });
            this.eOt.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.eOt.dismiss();
                }
            });
            this.eOt.bg(true);
        }
        this.eOt.b(baseActivity.getPageContext()).BF();
    }

    public void iw(boolean z) {
        int i;
        if (z) {
            al.c(this.eOp, e.f.icon_pop_pass);
            i = e.j.relate_forum_is_followed;
            this.eOn.setTag(0);
        } else {
            al.c(this.eOp, e.f.icon_brief_attention);
            i = e.j.attention;
            this.eOn.setTag(1);
        }
        this.eOo.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void ix(boolean z) {
        if (z) {
            this.eOr.setVisibility(0);
        } else {
            this.eOr.setVisibility(8);
        }
    }
}
