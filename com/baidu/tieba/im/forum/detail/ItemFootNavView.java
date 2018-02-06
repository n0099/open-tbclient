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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel cdg;
    private AntiHelper.a dVF;
    private RecommendForumInfo eBZ;
    private ForumDetailActivity eCf;
    private ViewGroup eCs;
    private TextView eCt;
    private ImageView eCu;
    private ViewGroup eCv;
    private View eCw;
    private boolean eCx;
    private com.baidu.tbadk.core.dialog.a eCy;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.eCx = false;
        this.dVF = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXN));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXN));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eCx = false;
        this.dVF = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXN));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXN));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.eCs = (ViewGroup) findViewById(d.g.fn_care_box);
        this.eCt = (TextView) findViewById(d.g.fn_care_btn);
        this.eCu = (ImageView) findViewById(d.g.icon_brief_care);
        this.eCv = (ViewGroup) findViewById(d.g.fn_enter_box);
        this.eCw = findViewById(d.g.foot_line);
    }

    public void a(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.eCf = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.eCx = forumDetailActivity.getIntent().getStringExtra("from_type").equals(ForumDetailActivityConfig.FromType.FRS.toString());
            this.eBZ = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            hv(recommendForumInfo.is_like.intValue() == 1);
            this.eCs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.eCv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.eCx) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.zd())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.eCf.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.eCs.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.eCx);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.zd())) {
                    TiebaStatic.eventStat(this.eCf.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.eCx);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(d.g.attention_icon);
        TextView textView = (TextView) inflate.findViewById(d.g.attention_title);
        aj.r(textView, d.C0140d.cp_cont_g);
        if (z) {
            imageView.setImageDrawable(aj.getDrawable(d.f.icon_tips_attention_ok));
            textView.setText(d.j.attention);
        } else {
            imageView.setImageDrawable(aj.getDrawable(d.f.icon_tips_attention_cancel));
            textView.setText(d.j.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.eCf.hr(true);
        } else {
            this.eCf.hr(false);
        }
        this.eCf.setSwitch(z);
        this.eCf.hs(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.cdg == null) {
            this.cdg = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.cdg.setFrom("detail_follow");
        this.cdg.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (ItemFootNavView.this.cdg.getErrorCode() == 22) {
                    ItemFootNavView.this.hu(true);
                    ItemFootNavView.this.hv(true);
                } else if (!AntiHelper.vQ(ItemFootNavView.this.cdg.getErrorCode())) {
                    if (ItemFootNavView.this.cdg.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.cdg.getErrorString());
                        return;
                    }
                    r rVar = (r) obj;
                    if (rVar != null) {
                        ItemFootNavView.this.hu(true);
                        TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.eBZ.forum_name);
                        ItemFootNavView.this.hv(true);
                        rVar.setLike(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                        return;
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(d.j.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.cdg.getBlockPopInfoData(), ItemFootNavView.this.dVF) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXN));
                }
            }
        });
        this.cdg.cc(this.eBZ.forum_name, String.valueOf(this.eBZ.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.eCy == null) {
            this.eCy = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.eCy.fb(d.j.forum_info_unlike_msg);
            this.eCy.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.eCy.dismiss();
                    w wVar = new w();
                    wVar.setFrom("bar_detail");
                    wVar.a(new w.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void m(String str, long j) {
                            ItemFootNavView.this.hu(false);
                            ItemFootNavView.this.hv(false);
                            if (ItemFootNavView.this.eBZ != null && ItemFootNavView.this.eBZ.forum_id.longValue() != 0) {
                                r rVar = new r();
                                rVar.setFid(j + "");
                                rVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.eBZ.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void n(String str, long j) {
                            baseActivity.showToast(baseActivity.getPageContext().getString(d.j.unlike_failure));
                        }
                    });
                    wVar.t(ItemFootNavView.this.eBZ.forum_name, ItemFootNavView.this.eBZ.forum_id.longValue());
                }
            });
            this.eCy.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.eCy.dismiss();
                }
            });
            this.eCy.ba(true);
        }
        this.eCy.b(baseActivity.getPageContext()).AU();
    }

    public void hv(boolean z) {
        int i;
        if (z) {
            aj.c(this.eCu, d.f.icon_pop_pass);
            i = d.j.relate_forum_is_followed;
            this.eCs.setTag(0);
        } else {
            aj.c(this.eCu, d.f.icon_brief_attention);
            i = d.j.attention;
            this.eCs.setTag(1);
        }
        this.eCt.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().aQ(i == 1);
        forumDetailActivity.getLayoutMode().aM(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void hw(boolean z) {
        if (z) {
            this.eCw.setVisibility(0);
        } else {
            this.eCw.setVisibility(8);
        }
    }
}
