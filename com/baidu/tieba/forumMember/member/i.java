package com.baidu.tieba.forumMember.member;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes10.dex */
public class i extends com.baidu.tieba.frs.h<j, k> {
    private LikeModel dKo;
    private int fRX;
    private int gUN;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.fRX = 0;
        this.gUN = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.m item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == R.id.like_btn) {
                            if (bc.checkUpIsLogin(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    i.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.dKo.eP(jVar.getForumName(), forumId);
                            }
                        } else if (view.getId() == R.id.user_level_name) {
                            String forumId2 = jVar.getForumId();
                            i.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_TBTITLE_ACTIVITY, new TbTitleActivityConfig(i.this.mContext, jVar.getForumName(), forumId2)));
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public k b(ViewGroup viewGroup) {
        if (this.dKo == null) {
            bmb();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) kVar);
        if (jVar != null && jVar.bNe() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = am.getColor(R.color.cp_cont_d);
            u bNe = jVar.bNe();
            if (TbadkCoreApplication.isLogin()) {
                if (bNe.isLike() == 1) {
                    kVar.gUR.setVisibility(8);
                    kVar.gUS.setVisibility(0);
                    kVar.gUS.setText(R.string.mydegree);
                    am.setImageResource(kVar.gTP, BitmapHelper.getSmallGradeResourceIdNew(bNe.cTI()));
                    if (StringUtils.isNull(bNe.getLevelName())) {
                        kVar.gTQ.setVisibility(8);
                    } else {
                        kVar.gTQ.setText(bNe.getLevelName());
                        kVar.gTQ.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(bNe.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + bNe.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.gUU.setText(spannableStringBuilder);
                    kVar.gUU.setVisibility(0);
                    kVar.gUY.setVisibility(0);
                    kVar.gUZ.setVisibility(0);
                } else {
                    kVar.gUR.setVisibility(0);
                    kVar.gUS.setVisibility(8);
                    kVar.gTP.setVisibility(8);
                    kVar.gTQ.setVisibility(8);
                    kVar.gUU.setVisibility(8);
                    kVar.gUY.setVisibility(8);
                    kVar.gUZ.setVisibility(8);
                }
            } else {
                kVar.gUR.setVisibility(8);
                kVar.gUS.setVisibility(8);
                kVar.gTP.setVisibility(8);
                kVar.gTQ.setVisibility(8);
                kVar.gUU.setVisibility(8);
                kVar.gUY.setVisibility(8);
                kVar.gUZ.setVisibility(8);
            }
            kVar.gUR.setTag(Integer.valueOf(i));
            kVar.gTQ.setTag(Integer.valueOf(i));
            kVar.gTQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            am.setBackgroundColor(kVar.gUV, R.color.cp_bg_line_d);
            am.setBackgroundColor(kVar.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(kVar.gUW, R.color.cp_bg_line_c);
            am.setBackgroundResource(kVar.gUR, R.drawable.frs_btn_like);
            am.setViewTextColor(kVar.gUR, R.color.white_alpha100, 1);
            am.setViewTextColor(kVar.gUS, R.color.cp_cont_b, 1);
            am.setViewTextColor(kVar.gTQ, R.color.cp_cont_d, 1);
            am.setViewTextColor(kVar.gUX, R.color.cp_cont_b, 1);
            am.setBackgroundResource(kVar.gUY, R.drawable.forum_member_exp_progress);
            am.setBackgroundColor(kVar.gUZ, R.color.cp_bg_line_c);
            if (this.fRX != bNe.cTI() || this.gUN != bNe.getCurScore()) {
                this.fRX = bNe.cTI();
                this.gUN = bNe.getCurScore();
                kVar.gUY.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, sQ(this.fRX)));
                float f = 0.0f;
                this.gUN = bNe.getCurScore();
                if (this.gUN > bNe.getLevelupScore()) {
                    this.gUN = bNe.getLevelupScore();
                }
                if (bNe.getLevelupScore() != 0) {
                    f = this.gUN / bNe.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.gUY, scaleAnimation, null);
            }
        }
        return view;
    }

    private void bmb() {
        if (this.mPageContext != null) {
            this.dKo = new LikeModel(this.mPageContext);
            this.dKo.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (!(obj instanceof u) || i.this.dKo.getErrorCode() != 0) {
                        if (AntiHelper.bq(i.this.dKo.getErrorCode(), i.this.dKo.getErrorString())) {
                            AntiHelper.bi(i.this.mPageContext.getPageActivity(), i.this.dKo.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.dKo.getErrorString());
                            return;
                        }
                    }
                    u uVar = (u) obj;
                    uVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                }
            });
        }
    }

    private int[] sQ(int i) {
        if (i <= 3) {
            return new int[]{-8331843, -10499102};
        }
        if (i <= 9) {
            return new int[]{-10499102, -154262};
        }
        if (i <= 15) {
            return new int[]{-154262, -148180};
        }
        return new int[]{-148180, -100818};
    }
}
