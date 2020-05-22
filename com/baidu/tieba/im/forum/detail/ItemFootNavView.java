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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
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
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import tbclient.RecommendForumInfo;
/* loaded from: classes13.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel dYI;
    private AntiHelper.a hLL;
    private RecommendForumInfo iyC;
    private ForumDetailActivity iyJ;
    private ViewGroup iyX;
    private TextView iyY;
    private ImageView iyZ;
    private ViewGroup iza;
    private View izb;
    private boolean izc;
    private com.baidu.tbadk.core.dialog.a izd;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.izc = false;
        this.hLL = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.izc = false;
        this.hLL = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.iyX = (ViewGroup) findViewById(R.id.fn_care_box);
        this.iyY = (TextView) findViewById(R.id.fn_care_btn);
        this.iyZ = (ImageView) findViewById(R.id.icon_brief_care);
        this.iza = (ViewGroup) findViewById(R.id.fn_enter_box);
        this.izb = findViewById(R.id.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.iyJ = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.izc = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.iyC = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            pc(recommendForumInfo.is_like.intValue() == 1);
            this.iyX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.iza.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.izc) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, BarDetailForDirSwitch.BAR_DETAIL_DIR)));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.aQj())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.iyJ.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.iyX.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.izc);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.aQj())) {
                    TiebaStatic.eventStat(this.iyJ.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.izc);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pb(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.attention_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.attention_title);
        am.setViewTextColor(textView, (int) R.color.cp_cont_g);
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
            this.iyJ.oY(true);
        } else {
            this.iyJ.oY(false);
        }
        this.iyJ.setSwitch(z);
        this.iyJ.oZ(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.dYI == null) {
            this.dYI = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.dYI.setFrom("detail_follow");
        this.dYI.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (ItemFootNavView.this.dYI.getErrorCode() == 22) {
                    ItemFootNavView.this.pb(true);
                    ItemFootNavView.this.pc(true);
                } else if (!AntiHelper.bv(ItemFootNavView.this.dYI.getErrorCode(), ItemFootNavView.this.dYI.getErrorString())) {
                    if (ItemFootNavView.this.dYI.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.dYI.getErrorString());
                        return;
                    }
                    u uVar = (u) obj;
                    if (uVar != null) {
                        if (uVar.getErrorCode() == 3250013) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), uVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aSY();
                            return;
                        } else if (!AntiHelper.Ea(uVar.getErrorCode())) {
                            ItemFootNavView.this.pb(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.iyC.forum_name);
                            ItemFootNavView.this.pc(true);
                            uVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.dYI.getBlockPopInfoData(), ItemFootNavView.this.hLL);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.dYI.getBlockPopInfoData(), ItemFootNavView.this.hLL) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_LIKE_BAR));
                }
            }
        });
        this.dYI.fq(this.iyC.forum_name, String.valueOf(this.iyC.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.izd == null) {
            this.izd = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.izd.kD(R.string.forum_info_unlike_msg);
            this.izd.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.izd.dismiss();
                    ac acVar = new ac();
                    acVar.setFrom(BarDetailForDirSwitch.BAR_DETAIL_DIR);
                    acVar.a(new ac.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void z(String str, long j) {
                            ItemFootNavView.this.pb(false);
                            ItemFootNavView.this.pc(false);
                            if (ItemFootNavView.this.iyC != null && ItemFootNavView.this.iyC.forum_id.longValue() != 0) {
                                u uVar = new u();
                                uVar.setFid(j + "");
                                uVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, ItemFootNavView.this.iyC.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void A(String str, long j) {
                            if (j == 3250013) {
                                if (aq.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                                }
                                BdToast.a(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aSY();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                        }
                    });
                    acVar.K(ItemFootNavView.this.iyC.forum_name, ItemFootNavView.this.iyC.forum_id.longValue());
                }
            });
            this.izd.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.izd.dismiss();
                }
            });
            this.izd.gX(true);
        }
        this.izd.b(baseActivity.getPageContext()).aST();
    }

    public void pc(boolean z) {
        int i;
        if (z) {
            am.setImageResource(this.iyZ, R.drawable.icon_pop_pass);
            i = R.string.relate_forum_is_followed;
            this.iyX.setTag(0);
        } else {
            am.setImageResource(this.iyZ, R.drawable.icon_brief_attention);
            i = R.string.attention;
            this.iyX.setTag(1);
        }
        this.iyY.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void pd(boolean z) {
        if (z) {
            this.izb.setVisibility(0);
        } else {
            this.izb.setVisibility(8);
        }
    }
}
