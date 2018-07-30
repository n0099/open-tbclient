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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel azq;
    private AntiHelper.a dGP;
    private RecommendForumInfo eqK;
    private ForumDetailActivity eqQ;
    private ViewGroup erd;
    private TextView ere;
    private ImageView erf;
    private ViewGroup erg;
    private View erh;
    private boolean eri;
    private com.baidu.tbadk.core.dialog.a erj;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.eri = false;
        this.dGP = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").r("obj_locate", at.a.art));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").r("obj_locate", at.a.art));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eri = false;
        this.dGP = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").r("obj_locate", at.a.art));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").r("obj_locate", at.a.art));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.erd = (ViewGroup) findViewById(d.g.fn_care_box);
        this.ere = (TextView) findViewById(d.g.fn_care_btn);
        this.erf = (ImageView) findViewById(d.g.icon_brief_care);
        this.erg = (ViewGroup) findViewById(d.g.fn_enter_box);
        this.erh = findViewById(d.g.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.eqQ = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.eri = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.eqK = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            hu(recommendForumInfo.is_like.intValue() == 1);
            this.erd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.erg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.eri) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.uY())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.eqQ.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.erd.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.eri);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.uY())) {
                    TiebaStatic.eventStat(this.eqQ.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.eri);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ht(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(d.g.attention_icon);
        TextView textView = (TextView) inflate.findViewById(d.g.attention_title);
        am.h(textView, d.C0140d.cp_cont_g);
        if (z) {
            imageView.setImageDrawable(am.getDrawable(d.f.icon_tips_attention_ok));
            textView.setText(d.j.attention);
        } else {
            imageView.setImageDrawable(am.getDrawable(d.f.icon_tips_attention_cancel));
            textView.setText(d.j.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.eqQ.hq(true);
        } else {
            this.eqQ.hq(false);
        }
        this.eqQ.setSwitch(z);
        this.eqQ.hr(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.azq == null) {
            this.azq = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.azq.setFrom("detail_follow");
        this.azq.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (ItemFootNavView.this.azq.getErrorCode() == 22) {
                    ItemFootNavView.this.ht(true);
                    ItemFootNavView.this.hu(true);
                } else if (!AntiHelper.al(ItemFootNavView.this.azq.getErrorCode(), ItemFootNavView.this.azq.getErrorString())) {
                    if (ItemFootNavView.this.azq.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.azq.getErrorString());
                        return;
                    }
                    r rVar = (r) obj;
                    if (rVar != null) {
                        if (rVar.getErrorCode() == 3250013) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), d.f.icon_toast_game_error, 3000).xn();
                            return;
                        } else if (!AntiHelper.tO(rVar.getErrorCode())) {
                            ItemFootNavView.this.ht(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.eqK.forum_name);
                            ItemFootNavView.this.hu(true);
                            rVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.azq.getBlockPopInfoData(), ItemFootNavView.this.dGP);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(d.j.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.azq.getBlockPopInfoData(), ItemFootNavView.this.dGP) != null) {
                    TiebaStatic.log(new an("c12534").r("obj_locate", at.a.art));
                }
            }
        });
        this.azq.ck(this.eqK.forum_name, String.valueOf(this.eqK.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.erj == null) {
            this.erj = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.erj.cf(d.j.forum_info_unlike_msg);
            this.erj.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.erj.dismiss();
                    w wVar = new w();
                    wVar.setFrom("bar_detail");
                    wVar.a(new w.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void m(String str, long j) {
                            ItemFootNavView.this.ht(false);
                            ItemFootNavView.this.hu(false);
                            if (ItemFootNavView.this.eqK != null && ItemFootNavView.this.eqK.forum_id.longValue() != 0) {
                                r rVar = new r();
                                rVar.setFid(j + "");
                                rVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.eqK.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void n(String str, long j) {
                            if (j == 3250013) {
                                if (ap.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(d.j.anti_account_exception_appealing);
                                }
                                BdToast.a(TbadkCoreApplication.getInst().getContext(), str, d.f.icon_toast_game_error, 3000).xn();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(d.j.unlike_failure));
                        }
                    });
                    wVar.t(ItemFootNavView.this.eqK.forum_name, ItemFootNavView.this.eqK.forum_id.longValue());
                }
            });
            this.erj.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.erj.dismiss();
                }
            });
            this.erj.av(true);
        }
        this.erj.b(baseActivity.getPageContext()).xf();
    }

    public void hu(boolean z) {
        int i;
        if (z) {
            am.c(this.erf, d.f.icon_pop_pass);
            i = d.j.relate_forum_is_followed;
            this.erd.setTag(0);
        } else {
            am.c(this.erf, d.f.icon_brief_attention);
            i = d.j.attention;
            this.erd.setTag(1);
        }
        this.ere.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void hv(boolean z) {
        if (z) {
            this.erh.setVisibility(0);
        } else {
            this.erh.setVisibility(8);
        }
    }
}
