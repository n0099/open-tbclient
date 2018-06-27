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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel bwM;
    private AntiHelper.a dEd;
    private RecommendForumInfo emR;
    private ForumDetailActivity emX;
    private ViewGroup enl;
    private TextView enm;
    private ImageView enn;
    private ViewGroup eno;
    private View enp;
    private boolean enq;
    private com.baidu.tbadk.core.dialog.a enr;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.enq = false;
        this.dEd = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arS));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arS));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.enq = false;
        this.dEd = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arS));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arS));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.i.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.enl = (ViewGroup) findViewById(d.g.fn_care_box);
        this.enm = (TextView) findViewById(d.g.fn_care_btn);
        this.enn = (ImageView) findViewById(d.g.icon_brief_care);
        this.eno = (ViewGroup) findViewById(d.g.fn_enter_box);
        this.enp = findViewById(d.g.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.emX = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.enq = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.emR = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            hr(recommendForumInfo.is_like.intValue() == 1);
            this.enl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.eno.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.enq) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.vk())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.emX.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.enl.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.enq);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.vk())) {
                    TiebaStatic.eventStat(this.emX.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.enq);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hq(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(d.g.attention_icon);
        TextView textView = (TextView) inflate.findViewById(d.g.attention_title);
        am.h(textView, d.C0142d.cp_cont_g);
        if (z) {
            imageView.setImageDrawable(am.getDrawable(d.f.icon_tips_attention_ok));
            textView.setText(d.k.attention);
        } else {
            imageView.setImageDrawable(am.getDrawable(d.f.icon_tips_attention_cancel));
            textView.setText(d.k.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.emX.hn(true);
        } else {
            this.emX.hn(false);
        }
        this.emX.setSwitch(z);
        this.emX.ho(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.bwM == null) {
            this.bwM = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.bwM.setFrom("detail_follow");
        this.bwM.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (ItemFootNavView.this.bwM.getErrorCode() == 22) {
                    ItemFootNavView.this.hq(true);
                    ItemFootNavView.this.hr(true);
                } else if (!AntiHelper.tQ(ItemFootNavView.this.bwM.getErrorCode())) {
                    if (ItemFootNavView.this.bwM.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.bwM.getErrorString());
                        return;
                    }
                    r rVar = (r) obj;
                    if (rVar != null) {
                        ItemFootNavView.this.hq(true);
                        TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.emR.forum_name);
                        ItemFootNavView.this.hr(true);
                        rVar.setLike(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                        return;
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(d.k.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.bwM.getBlockPopInfoData(), ItemFootNavView.this.dEd) != null) {
                    TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arS));
                }
            }
        });
        this.bwM.cn(this.emR.forum_name, String.valueOf(this.emR.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.enr == null) {
            this.enr = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.enr.cd(d.k.forum_info_unlike_msg);
            this.enr.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.enr.dismiss();
                    w wVar = new w();
                    wVar.setFrom("bar_detail");
                    wVar.a(new w.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void m(String str, long j) {
                            ItemFootNavView.this.hq(false);
                            ItemFootNavView.this.hr(false);
                            if (ItemFootNavView.this.emR != null && ItemFootNavView.this.emR.forum_id.longValue() != 0) {
                                r rVar = new r();
                                rVar.setFid(j + "");
                                rVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.emR.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void n(String str, long j) {
                            baseActivity.showToast(baseActivity.getPageContext().getString(d.k.unlike_failure));
                        }
                    });
                    wVar.t(ItemFootNavView.this.emR.forum_name, ItemFootNavView.this.emR.forum_id.longValue());
                }
            });
            this.enr.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.enr.dismiss();
                }
            });
            this.enr.ax(true);
        }
        this.enr.b(baseActivity.getPageContext()).xn();
    }

    public void hr(boolean z) {
        int i;
        if (z) {
            am.c(this.enn, d.f.icon_pop_pass);
            i = d.k.relate_forum_is_followed;
            this.enl.setTag(0);
        } else {
            am.c(this.enn, d.f.icon_brief_attention);
            i = d.k.attention;
            this.enl.setTag(1);
        }
        this.enm.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void hs(boolean z) {
        if (z) {
            this.enp.setVisibility(0);
        } else {
            this.enp.setVisibility(8);
        }
    }
}
