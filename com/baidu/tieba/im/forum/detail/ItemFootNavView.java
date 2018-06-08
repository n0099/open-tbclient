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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel bvr;
    private AntiHelper.a dAR;
    private RecommendForumInfo eiY;
    private ForumDetailActivity eje;
    private ViewGroup ejr;
    private TextView ejs;
    private ImageView ejt;
    private ViewGroup eju;
    private View ejv;
    private boolean ejw;
    private com.baidu.tbadk.core.dialog.a ejx;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.ejw = false;
        this.dAR = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").r("obj_locate", as.a.arp));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").r("obj_locate", as.a.arp));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ejw = false;
        this.dAR = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").r("obj_locate", as.a.arp));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").r("obj_locate", as.a.arp));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.i.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.ejr = (ViewGroup) findViewById(d.g.fn_care_box);
        this.ejs = (TextView) findViewById(d.g.fn_care_btn);
        this.ejt = (ImageView) findViewById(d.g.icon_brief_care);
        this.eju = (ViewGroup) findViewById(d.g.fn_enter_box);
        this.ejv = findViewById(d.g.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.eje = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.ejw = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.eiY = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            hh(recommendForumInfo.is_like.intValue() == 1);
            this.ejr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.eju.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.ejw) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.vb())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.eje.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.ejr.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.ejw);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.vb())) {
                    TiebaStatic.eventStat(this.eje.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.ejw);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hg(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(d.g.attention_icon);
        TextView textView = (TextView) inflate.findViewById(d.g.attention_title);
        al.h(textView, d.C0141d.cp_cont_g);
        if (z) {
            imageView.setImageDrawable(al.getDrawable(d.f.icon_tips_attention_ok));
            textView.setText(d.k.attention);
        } else {
            imageView.setImageDrawable(al.getDrawable(d.f.icon_tips_attention_cancel));
            textView.setText(d.k.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.eje.hd(true);
        } else {
            this.eje.hd(false);
        }
        this.eje.setSwitch(z);
        this.eje.he(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.bvr == null) {
            this.bvr = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.bvr.setFrom("detail_follow");
        this.bvr.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (ItemFootNavView.this.bvr.getErrorCode() == 22) {
                    ItemFootNavView.this.hg(true);
                    ItemFootNavView.this.hh(true);
                } else if (!AntiHelper.tE(ItemFootNavView.this.bvr.getErrorCode())) {
                    if (ItemFootNavView.this.bvr.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.bvr.getErrorString());
                        return;
                    }
                    r rVar = (r) obj;
                    if (rVar != null) {
                        ItemFootNavView.this.hg(true);
                        TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.eiY.forum_name);
                        ItemFootNavView.this.hh(true);
                        rVar.setLike(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                        return;
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(d.k.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.bvr.getBlockPopInfoData(), ItemFootNavView.this.dAR) != null) {
                    TiebaStatic.log(new am("c12534").r("obj_locate", as.a.arp));
                }
            }
        });
        this.bvr.cj(this.eiY.forum_name, String.valueOf(this.eiY.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.ejx == null) {
            this.ejx = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.ejx.cc(d.k.forum_info_unlike_msg);
            this.ejx.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.ejx.dismiss();
                    w wVar = new w();
                    wVar.setFrom("bar_detail");
                    wVar.a(new w.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void m(String str, long j) {
                            ItemFootNavView.this.hg(false);
                            ItemFootNavView.this.hh(false);
                            if (ItemFootNavView.this.eiY != null && ItemFootNavView.this.eiY.forum_id.longValue() != 0) {
                                r rVar = new r();
                                rVar.setFid(j + "");
                                rVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.eiY.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void n(String str, long j) {
                            baseActivity.showToast(baseActivity.getPageContext().getString(d.k.unlike_failure));
                        }
                    });
                    wVar.t(ItemFootNavView.this.eiY.forum_name, ItemFootNavView.this.eiY.forum_id.longValue());
                }
            });
            this.ejx.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.ejx.dismiss();
                }
            });
            this.ejx.av(true);
        }
        this.ejx.b(baseActivity.getPageContext()).xa();
    }

    public void hh(boolean z) {
        int i;
        if (z) {
            al.c(this.ejt, d.f.icon_pop_pass);
            i = d.k.relate_forum_is_followed;
            this.ejr.setTag(0);
        } else {
            al.c(this.ejt, d.f.icon_brief_attention);
            i = d.k.attention;
            this.ejr.setTag(1);
        }
        this.ejs.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void hi(boolean z) {
        if (z) {
            this.ejv.setVisibility(0);
        } else {
            this.ejv.setVisibility(8);
        }
    }
}
