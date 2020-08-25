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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import tbclient.RecommendForumInfo;
/* loaded from: classes20.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel ewX;
    private AntiHelper.a itS;
    private RecommendForumInfo jnG;
    private ForumDetailActivity jnN;
    private ViewGroup job;
    private TextView joc;
    private ImageView jod;
    private ViewGroup joe;
    private View jof;
    private boolean jog;
    private com.baidu.tbadk.core.dialog.a joh;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.jog = false;
        this.itS = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jog = false;
        this.itS = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.job = (ViewGroup) findViewById(R.id.fn_care_box);
        this.joc = (TextView) findViewById(R.id.fn_care_btn);
        this.jod = (ImageView) findViewById(R.id.icon_brief_care);
        this.joe = (ViewGroup) findViewById(R.id.fn_enter_box);
        this.jof = findViewById(R.id.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.jnN = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.jog = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.jnG = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            qz(recommendForumInfo.is_like.intValue() == 1);
            this.job.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.joe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.jog) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, BarDetailForDirSwitch.BAR_DETAIL_DIR)));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.beq())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.jnN.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.job.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.jog);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.beq())) {
                    TiebaStatic.eventStat(this.jnN.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.jog);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qy(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.attention_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.attention_title);
        ap.setViewTextColor(textView, R.color.cp_cont_g);
        if (z) {
            imageView.setImageDrawable(ap.getDrawable(R.drawable.icon_tips_attention_ok));
            textView.setText(R.string.attention);
        } else {
            imageView.setImageDrawable(ap.getDrawable(R.drawable.icon_tips_attention_cancel));
            textView.setText(R.string.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.jnN.qv(true);
        } else {
            this.jnN.qv(false);
        }
        this.jnN.setSwitch(z);
        this.jnN.qw(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.ewX == null) {
            this.ewX = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.ewX.setFrom("detail_follow");
        this.ewX.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (ItemFootNavView.this.ewX.getErrorCode() == 22) {
                    ItemFootNavView.this.qy(true);
                    ItemFootNavView.this.qz(true);
                } else if (!AntiHelper.bz(ItemFootNavView.this.ewX.getErrorCode(), ItemFootNavView.this.ewX.getErrorString())) {
                    if (ItemFootNavView.this.ewX.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.ewX.getErrorString());
                        return;
                    }
                    v vVar = (v) obj;
                    if (vVar != null) {
                        if (vVar.getErrorCode() == 3250013) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), vVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bhm();
                            return;
                        } else if (!AntiHelper.HX(vVar.getErrorCode())) {
                            ItemFootNavView.this.qy(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.jnG.forum_name);
                            ItemFootNavView.this.qz(true);
                            vVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.ewX.getBlockPopInfoData(), ItemFootNavView.this.itS);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.ewX.getBlockPopInfoData(), ItemFootNavView.this.itS) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
                }
            }
        });
        this.ewX.fQ(this.jnG.forum_name, String.valueOf(this.jnG.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.joh == null) {
            this.joh = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.joh.nt(R.string.forum_info_unlike_msg);
            this.joh.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.joh.dismiss();
                    ad adVar = new ad();
                    adVar.setFrom(BarDetailForDirSwitch.BAR_DETAIL_DIR);
                    adVar.a(new ad.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void y(String str, long j) {
                            ItemFootNavView.this.qy(false);
                            ItemFootNavView.this.qz(false);
                            if (ItemFootNavView.this.jnG != null && ItemFootNavView.this.jnG.forum_id.longValue() != 0) {
                                v vVar = new v();
                                vVar.setFid(j + "");
                                vVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, ItemFootNavView.this.jnG.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void z(String str, long j) {
                            if (j == 3250013) {
                                if (at.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                                }
                                BdToast.a(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bhm();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                        }
                    });
                    adVar.K(ItemFootNavView.this.jnG.forum_name, ItemFootNavView.this.jnG.forum_id.longValue());
                }
            });
            this.joh.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.joh.dismiss();
                }
            });
            this.joh.ig(true);
        }
        this.joh.b(baseActivity.getPageContext()).bhg();
    }

    public void qz(boolean z) {
        int i;
        if (z) {
            ap.setImageResource(this.jod, R.drawable.icon_pop_pass);
            i = R.string.relate_forum_is_followed;
            this.job.setTag(0);
        } else {
            ap.setImageResource(this.jod, R.drawable.icon_brief_attention);
            i = R.string.attention;
            this.job.setTag(1);
        }
        this.joc.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void qA(boolean z) {
        if (z) {
            this.jof.setVisibility(0);
        } else {
            this.jof.setVisibility(8);
        }
    }
}
