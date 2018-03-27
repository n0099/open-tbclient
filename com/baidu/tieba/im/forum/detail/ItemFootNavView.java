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
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.x;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel ccX;
    private AntiHelper.a dVz;
    private View eCA;
    private boolean eCB;
    private com.baidu.tbadk.core.dialog.a eCC;
    private RecommendForumInfo eCd;
    private ForumDetailActivity eCj;
    private ViewGroup eCw;
    private TextView eCx;
    private ImageView eCy;
    private ViewGroup eCz;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.eCB = false;
        this.dVz = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXD));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXD));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eCB = false;
        this.dVz = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXD));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXD));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.eCw = (ViewGroup) findViewById(d.g.fn_care_box);
        this.eCx = (TextView) findViewById(d.g.fn_care_btn);
        this.eCy = (ImageView) findViewById(d.g.icon_brief_care);
        this.eCz = (ViewGroup) findViewById(d.g.fn_enter_box);
        this.eCA = findViewById(d.g.foot_line);
    }

    public void a(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.eCj = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.eCB = forumDetailActivity.getIntent().getStringExtra("from_type").equals(ForumDetailActivityConfig.FromType.FRS.toString());
            this.eCd = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            hA(recommendForumInfo.is_like.intValue() == 1);
            this.eCw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.eCz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.eCB) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.zd())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.eCj.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.eCw.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.eCB);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.zd())) {
                    TiebaStatic.eventStat(this.eCj.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.eCB);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hz(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(d.g.attention_icon);
        TextView textView = (TextView) inflate.findViewById(d.g.attention_title);
        aj.r(textView, d.C0141d.cp_cont_g);
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
            this.eCj.hw(true);
        } else {
            this.eCj.hw(false);
        }
        this.eCj.setSwitch(z);
        this.eCj.hx(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.ccX == null) {
            this.ccX = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.ccX.setFrom("detail_follow");
        this.ccX.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (ItemFootNavView.this.ccX.getErrorCode() == 22) {
                    ItemFootNavView.this.hz(true);
                    ItemFootNavView.this.hA(true);
                } else if (!AntiHelper.vR(ItemFootNavView.this.ccX.getErrorCode())) {
                    if (ItemFootNavView.this.ccX.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.ccX.getErrorString());
                        return;
                    }
                    s sVar = (s) obj;
                    if (sVar != null) {
                        ItemFootNavView.this.hz(true);
                        TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.eCd.forum_name);
                        ItemFootNavView.this.hA(true);
                        sVar.setLike(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, sVar));
                        return;
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(d.j.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.ccX.getBlockPopInfoData(), ItemFootNavView.this.dVz) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXD));
                }
            }
        });
        this.ccX.cc(this.eCd.forum_name, String.valueOf(this.eCd.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.eCC == null) {
            this.eCC = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.eCC.fb(d.j.forum_info_unlike_msg);
            this.eCC.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.eCC.dismiss();
                    x xVar = new x();
                    xVar.setFrom("bar_detail");
                    xVar.a(new x.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.x.a
                        public void m(String str, long j) {
                            ItemFootNavView.this.hz(false);
                            ItemFootNavView.this.hA(false);
                            if (ItemFootNavView.this.eCd != null && ItemFootNavView.this.eCd.forum_id.longValue() != 0) {
                                s sVar = new s();
                                sVar.setFid(j + "");
                                sVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, sVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.eCd.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.x.a
                        public void n(String str, long j) {
                            baseActivity.showToast(baseActivity.getPageContext().getString(d.j.unlike_failure));
                        }
                    });
                    xVar.t(ItemFootNavView.this.eCd.forum_name, ItemFootNavView.this.eCd.forum_id.longValue());
                }
            });
            this.eCC.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.eCC.dismiss();
                }
            });
            this.eCC.ba(true);
        }
        this.eCC.b(baseActivity.getPageContext()).AV();
    }

    public void hA(boolean z) {
        int i;
        if (z) {
            aj.c(this.eCy, d.f.icon_pop_pass);
            i = d.j.relate_forum_is_followed;
            this.eCw.setTag(0);
        } else {
            aj.c(this.eCy, d.f.icon_brief_attention);
            i = d.j.attention;
            this.eCw.setTag(1);
        }
        this.eCx.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().aQ(i == 1);
        forumDetailActivity.getLayoutMode().aM(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void hB(boolean z) {
        if (z) {
            this.eCA.setVisibility(0);
        } else {
            this.eCA.setVisibility(8);
        }
    }
}
