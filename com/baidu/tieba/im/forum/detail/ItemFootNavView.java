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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel cco;
    private AntiHelper.a fMz;
    private RecommendForumInfo gyF;
    private ForumDetailActivity gyN;
    private ViewGroup gza;
    private TextView gzb;
    private ImageView gzc;
    private ViewGroup gzd;
    private View gze;
    private boolean gzf;
    private com.baidu.tbadk.core.dialog.a gzg;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.gzf = false;
        this.fMz = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bTg));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bTg));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gzf = false;
        this.fMz = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bTg));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bTg));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.gza = (ViewGroup) findViewById(R.id.fn_care_box);
        this.gzb = (TextView) findViewById(R.id.fn_care_btn);
        this.gzc = (ImageView) findViewById(R.id.icon_brief_care);
        this.gzd = (ViewGroup) findViewById(R.id.fn_enter_box);
        this.gze = findViewById(R.id.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.gyN = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.gzf = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.gyF = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            lP(recommendForumInfo.is_like.intValue() == 1);
            this.gza.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.gzd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.gzf) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.adi())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.gyN.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.gza.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.gzf);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.adi())) {
                    TiebaStatic.eventStat(this.gyN.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.gzf);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.attention_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.attention_title);
        al.j(textView, R.color.cp_cont_g);
        if (z) {
            imageView.setImageDrawable(al.getDrawable(R.drawable.icon_tips_attention_ok));
            textView.setText(R.string.attention);
        } else {
            imageView.setImageDrawable(al.getDrawable(R.drawable.icon_tips_attention_cancel));
            textView.setText(R.string.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.gyN.lL(true);
        } else {
            this.gyN.lL(false);
        }
        this.gyN.setSwitch(z);
        this.gyN.lM(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.cco == null) {
            this.cco = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.cco.setFrom("detail_follow");
        this.cco.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (ItemFootNavView.this.cco.getErrorCode() == 22) {
                    ItemFootNavView.this.lO(true);
                    ItemFootNavView.this.lP(true);
                } else if (!AntiHelper.aG(ItemFootNavView.this.cco.getErrorCode(), ItemFootNavView.this.cco.getErrorString())) {
                    if (ItemFootNavView.this.cco.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.cco.getErrorString());
                        return;
                    }
                    r rVar = (r) obj;
                    if (rVar != null) {
                        if (rVar.getErrorCode() == 3250013) {
                            BdToast.b(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), R.drawable.icon_toast_game_error, 3000).afO();
                            return;
                        } else if (!AntiHelper.AD(rVar.getErrorCode())) {
                            ItemFootNavView.this.lO(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.gyF.forum_name);
                            ItemFootNavView.this.lP(true);
                            rVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.cco.getBlockPopInfoData(), ItemFootNavView.this.fMz);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.cco.getBlockPopInfoData(), ItemFootNavView.this.fMz) != null) {
                    TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bTg));
                }
            }
        });
        this.cco.ek(this.gyF.forum_name, String.valueOf(this.gyF.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.gzg == null) {
            this.gzg = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.gzg.ho(R.string.forum_info_unlike_msg);
            this.gzg.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.gzg.dismiss();
                    w wVar = new w();
                    wVar.setFrom("bar_detail");
                    wVar.a(new w.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void u(String str, long j) {
                            ItemFootNavView.this.lO(false);
                            ItemFootNavView.this.lP(false);
                            if (ItemFootNavView.this.gyF != null && ItemFootNavView.this.gyF.forum_id.longValue() != 0) {
                                r rVar = new r();
                                rVar.setFid(j + "");
                                rVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.gyF.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void v(String str, long j) {
                            if (j == 3250013) {
                                if (ap.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                                }
                                BdToast.b(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_toast_game_error, 3000).afO();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                        }
                    });
                    wVar.C(ItemFootNavView.this.gyF.forum_name, ItemFootNavView.this.gyF.forum_id.longValue());
                }
            });
            this.gzg.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.gzg.dismiss();
                }
            });
            this.gzg.dN(true);
        }
        this.gzg.b(baseActivity.getPageContext()).afG();
    }

    public void lP(boolean z) {
        int i;
        if (z) {
            al.c(this.gzc, (int) R.drawable.icon_pop_pass);
            i = R.string.relate_forum_is_followed;
            this.gza.setTag(0);
        } else {
            al.c(this.gzc, (int) R.drawable.icon_brief_attention);
            i = R.string.attention;
            this.gza.setTag(1);
        }
        this.gzb.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void lQ(boolean z) {
        if (z) {
            this.gze.setVisibility(0);
        } else {
            this.gze.setVisibility(8);
        }
    }
}
