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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.y;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel cer;
    private AntiHelper.a fUb;
    private RecommendForumInfo gHA;
    private ForumDetailActivity gHH;
    private ViewGroup gHU;
    private TextView gHV;
    private ImageView gHW;
    private ViewGroup gHX;
    private View gHY;
    private boolean gHZ;
    private com.baidu.tbadk.core.dialog.a gIa;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.gHZ = false;
        this.fUb = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").P("obj_locate", at.a.bUQ));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").P("obj_locate", at.a.bUQ));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gHZ = false;
        this.fUb = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").P("obj_locate", at.a.bUQ));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").P("obj_locate", at.a.bUQ));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.gHU = (ViewGroup) findViewById(R.id.fn_care_box);
        this.gHV = (TextView) findViewById(R.id.fn_care_btn);
        this.gHW = (ImageView) findViewById(R.id.icon_brief_care);
        this.gHX = (ViewGroup) findViewById(R.id.fn_enter_box);
        this.gHY = findViewById(R.id.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.gHH = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.gHZ = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.gHA = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            mg(recommendForumInfo.is_like.intValue() == 1);
            this.gHU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.gHX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.gHZ) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.aep())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.gHH.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.gHU.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.gHZ);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.aep())) {
                    TiebaStatic.eventStat(this.gHH.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.gHZ);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mf(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.attention_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.attention_title);
        am.j(textView, R.color.cp_cont_g);
        if (z) {
            imageView.setImageDrawable(am.getDrawable(R.drawable.icon_tips_attention_ok));
            textView.setText(R.string.attention);
        } else {
            imageView.setImageDrawable(am.getDrawable(R.drawable.icon_tips_attention_cancel));
            textView.setText(R.string.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.gHH.mc(true);
        } else {
            this.gHH.mc(false);
        }
        this.gHH.setSwitch(z);
        this.gHH.md(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.cer == null) {
            this.cer = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.cer.setFrom("detail_follow");
        this.cer.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (ItemFootNavView.this.cer.getErrorCode() == 22) {
                    ItemFootNavView.this.mf(true);
                    ItemFootNavView.this.mg(true);
                } else if (!AntiHelper.aG(ItemFootNavView.this.cer.getErrorCode(), ItemFootNavView.this.cer.getErrorString())) {
                    if (ItemFootNavView.this.cer.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.cer.getErrorString());
                        return;
                    }
                    t tVar = (t) obj;
                    if (tVar != null) {
                        if (tVar.getErrorCode() == 3250013) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), tVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake_n_svg, 3000, true).agW();
                            return;
                        } else if (!AntiHelper.Bp(tVar.getErrorCode())) {
                            ItemFootNavView.this.mf(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.gHA.forum_name);
                            ItemFootNavView.this.mg(true);
                            tVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, tVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.cer.getBlockPopInfoData(), ItemFootNavView.this.fUb);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.cer.getBlockPopInfoData(), ItemFootNavView.this.fUb) != null) {
                    TiebaStatic.log(new an("c12534").P("obj_locate", at.a.bUQ));
                }
            }
        });
        this.cer.em(this.gHA.forum_name, String.valueOf(this.gHA.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.gIa == null) {
            this.gIa = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.gIa.hv(R.string.forum_info_unlike_msg);
            this.gIa.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.gIa.dismiss();
                    y yVar = new y();
                    yVar.setFrom("bar_detail");
                    yVar.a(new y.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.y.a
                        public void w(String str, long j) {
                            ItemFootNavView.this.mf(false);
                            ItemFootNavView.this.mg(false);
                            if (ItemFootNavView.this.gHA != null && ItemFootNavView.this.gHA.forum_id.longValue() != 0) {
                                t tVar = new t();
                                tVar.setFid(j + "");
                                tVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, tVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.gHA.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.y.a
                        public void x(String str, long j) {
                            if (j == 3250013) {
                                if (aq.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                                }
                                BdToast.a(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_pure_toast_mistake_n_svg, 3000, true).agW();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                        }
                    });
                    yVar.E(ItemFootNavView.this.gHA.forum_name, ItemFootNavView.this.gHA.forum_id.longValue());
                }
            });
            this.gIa.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.gIa.dismiss();
                }
            });
            this.gIa.dR(true);
        }
        this.gIa.b(baseActivity.getPageContext()).agO();
    }

    public void mg(boolean z) {
        int i;
        if (z) {
            am.c(this.gHW, (int) R.drawable.icon_pop_pass);
            i = R.string.relate_forum_is_followed;
            this.gHU.setTag(0);
        } else {
            am.c(this.gHW, (int) R.drawable.icon_brief_attention);
            i = R.string.attention;
            this.gHU.setTag(1);
        }
        this.gHV.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void mh(boolean z) {
        if (z) {
            this.gHY.setVisibility(0);
        } else {
            this.gHY.setVisibility(8);
        }
    }
}
