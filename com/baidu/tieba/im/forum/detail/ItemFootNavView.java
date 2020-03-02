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
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.y;
import tbclient.RecommendForumInfo;
/* loaded from: classes13.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel djU;
    private AntiHelper.a gLY;
    private ViewGroup hyJ;
    private TextView hyK;
    private ImageView hyL;
    private ViewGroup hyM;
    private View hyN;
    private boolean hyO;
    private com.baidu.tbadk.core.dialog.a hyP;
    private RecommendForumInfo hyo;
    private ForumDetailActivity hyv;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.hyO = false;
        this.gLY = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hyO = false;
        this.gLY = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.hyJ = (ViewGroup) findViewById(R.id.fn_care_box);
        this.hyK = (TextView) findViewById(R.id.fn_care_btn);
        this.hyL = (ImageView) findViewById(R.id.icon_brief_care);
        this.hyM = (ViewGroup) findViewById(R.id.fn_enter_box);
        this.hyN = findViewById(R.id.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.hyv = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.hyO = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.hyo = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            nw(recommendForumInfo.is_like.intValue() == 1);
            this.hyJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.hyM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.hyO) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, BarDetailForDirSwitch.BAR_DETAIL_DIR)));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.aCa())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.hyv.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.hyJ.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.hyO);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.aCa())) {
                    TiebaStatic.eventStat(this.hyv.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.hyO);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv(boolean z) {
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
            this.hyv.ns(true);
        } else {
            this.hyv.ns(false);
        }
        this.hyv.setSwitch(z);
        this.hyv.nt(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.djU == null) {
            this.djU = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.djU.setFrom("detail_follow");
        this.djU.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (ItemFootNavView.this.djU.getErrorCode() == 22) {
                    ItemFootNavView.this.nv(true);
                    ItemFootNavView.this.nw(true);
                } else if (!AntiHelper.bb(ItemFootNavView.this.djU.getErrorCode(), ItemFootNavView.this.djU.getErrorString())) {
                    if (ItemFootNavView.this.djU.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.djU.getErrorString());
                        return;
                    }
                    t tVar = (t) obj;
                    if (tVar != null) {
                        if (tVar.getErrorCode() == 3250013) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), tVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEH();
                            return;
                        } else if (!AntiHelper.CD(tVar.getErrorCode())) {
                            ItemFootNavView.this.nv(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.hyo.forum_name);
                            ItemFootNavView.this.nw(true);
                            tVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.djU.getBlockPopInfoData(), ItemFootNavView.this.gLY);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.djU.getBlockPopInfoData(), ItemFootNavView.this.gLY) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_BAR));
                }
            }
        });
        this.djU.eC(this.hyo.forum_name, String.valueOf(this.hyo.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.hyP == null) {
            this.hyP = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.hyP.jW(R.string.forum_info_unlike_msg);
            this.hyP.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.hyP.dismiss();
                    y yVar = new y();
                    yVar.setFrom(BarDetailForDirSwitch.BAR_DETAIL_DIR);
                    yVar.a(new y.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.y.a
                        public void D(String str, long j) {
                            ItemFootNavView.this.nv(false);
                            ItemFootNavView.this.nw(false);
                            if (ItemFootNavView.this.hyo != null && ItemFootNavView.this.hyo.forum_id.longValue() != 0) {
                                t tVar = new t();
                                tVar.setFid(j + "");
                                tVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, ItemFootNavView.this.hyo.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.y.a
                        public void E(String str, long j) {
                            if (j == 3250013) {
                                if (aq.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                                }
                                BdToast.a(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aEH();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                        }
                    });
                    yVar.L(ItemFootNavView.this.hyo.forum_name, ItemFootNavView.this.hyo.forum_id.longValue());
                }
            });
            this.hyP.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.hyP.dismiss();
                }
            });
            this.hyP.fH(true);
        }
        this.hyP.b(baseActivity.getPageContext()).aEC();
    }

    public void nw(boolean z) {
        int i;
        if (z) {
            am.setImageResource(this.hyL, R.drawable.icon_pop_pass);
            i = R.string.relate_forum_is_followed;
            this.hyJ.setTag(0);
        } else {
            am.setImageResource(this.hyL, R.drawable.icon_brief_attention);
            i = R.string.attention;
            this.hyJ.setTag(1);
        }
        this.hyK.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void nx(boolean z) {
        if (z) {
            this.hyN.setVisibility(0);
        } else {
            this.hyN.setVisibility(8);
        }
    }
}
