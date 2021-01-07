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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes8.dex */
public class g extends com.baidu.tieba.frs.k<h, FrsMemberHeaderViewHolder> {
    private LikeModel fpO;
    private int hRm;
    private int jbt;
    private View.OnClickListener mClickListener;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.hRm = 0;
        this.jbt = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.n item = g.this.getItem(((Integer) tag).intValue());
                    if (item instanceof h) {
                        h hVar = (h) item;
                        if (view.getId() == R.id.like_btn) {
                            if (bg.checkUpIsLogin(g.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    g.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = hVar.getForumId();
                                g.this.fpO.gr(hVar.getForumName(), forumId);
                            }
                        } else if (view.getId() == R.id.user_level_name) {
                            String forumId2 = hVar.getForumId();
                            g.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_TBTITLE_ACTIVITY, new TbTitleActivityConfig(g.this.mContext, hVar.getForumName(), forumId2)));
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bo */
    public FrsMemberHeaderViewHolder e(ViewGroup viewGroup) {
        if (this.fpO == null) {
            bVt();
        }
        return new FrsMemberHeaderViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, FrsMemberHeaderViewHolder frsMemberHeaderViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) hVar, (h) frsMemberHeaderViewHolder);
        if (hVar != null && hVar.cDt() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = ao.getColor(R.color.CAM_X0109);
            w cDt = hVar.cDt();
            if (TbadkCoreApplication.isLogin()) {
                if (cDt.isLike() == 1) {
                    frsMemberHeaderViewHolder.jbx.setVisibility(8);
                    frsMemberHeaderViewHolder.jby.setVisibility(0);
                    frsMemberHeaderViewHolder.jby.setText(R.string.mydegree);
                    ao.setImageResource(frsMemberHeaderViewHolder.jaw, BitmapHelper.getSmallGradeResourceIdNew(cDt.bNV()));
                    if (StringUtils.isNull(cDt.getLevelName())) {
                        frsMemberHeaderViewHolder.jax.setVisibility(8);
                    } else {
                        frsMemberHeaderViewHolder.jax.setText(cDt.getLevelName());
                        frsMemberHeaderViewHolder.jax.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(cDt.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + cDt.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    frsMemberHeaderViewHolder.fiT.setText(spannableStringBuilder);
                    frsMemberHeaderViewHolder.fiT.setVisibility(0);
                    frsMemberHeaderViewHolder.jbD.setVisibility(0);
                    frsMemberHeaderViewHolder.jbE.setVisibility(0);
                } else {
                    frsMemberHeaderViewHolder.jbx.setVisibility(0);
                    frsMemberHeaderViewHolder.jby.setVisibility(8);
                    frsMemberHeaderViewHolder.jaw.setVisibility(8);
                    frsMemberHeaderViewHolder.jax.setVisibility(8);
                    frsMemberHeaderViewHolder.fiT.setVisibility(8);
                    frsMemberHeaderViewHolder.jbD.setVisibility(8);
                    frsMemberHeaderViewHolder.jbE.setVisibility(8);
                }
            } else {
                frsMemberHeaderViewHolder.jbx.setVisibility(8);
                frsMemberHeaderViewHolder.jby.setVisibility(8);
                frsMemberHeaderViewHolder.jaw.setVisibility(8);
                frsMemberHeaderViewHolder.jax.setVisibility(8);
                frsMemberHeaderViewHolder.fiT.setVisibility(8);
                frsMemberHeaderViewHolder.jbD.setVisibility(8);
                frsMemberHeaderViewHolder.jbE.setVisibility(8);
            }
            frsMemberHeaderViewHolder.jbx.setTag(Integer.valueOf(i));
            frsMemberHeaderViewHolder.jax.setTag(Integer.valueOf(i));
            frsMemberHeaderViewHolder.jax.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            ao.setBackgroundColor(frsMemberHeaderViewHolder.jbA, R.color.CAM_X0201);
            ao.setBackgroundColor(frsMemberHeaderViewHolder.dDI, R.color.CAM_X0204);
            ao.setBackgroundColor(frsMemberHeaderViewHolder.jbB, R.color.CAM_X0204);
            ao.setBackgroundResource(frsMemberHeaderViewHolder.jbx, R.drawable.frs_btn_like);
            ao.setViewTextColor(frsMemberHeaderViewHolder.jbx, R.color.white_alpha100, 1);
            ao.setViewTextColor(frsMemberHeaderViewHolder.jby, R.color.CAM_X0105, 1);
            ao.setViewTextColor(frsMemberHeaderViewHolder.jax, R.color.CAM_X0109, 1);
            ao.setViewTextColor(frsMemberHeaderViewHolder.jbC, R.color.CAM_X0105, 1);
            ao.setBackgroundResource(frsMemberHeaderViewHolder.jbD, R.drawable.forum_member_exp_progress);
            ao.setBackgroundColor(frsMemberHeaderViewHolder.jbE, R.color.CAM_X0204);
            if (this.hRm != cDt.bNV() || this.jbt != cDt.getCurScore()) {
                this.hRm = cDt.bNV();
                this.jbt = cDt.getCurScore();
                frsMemberHeaderViewHolder.jbD.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, zG(this.hRm)));
                float f = 0.0f;
                this.jbt = cDt.getCurScore();
                if (this.jbt > cDt.getLevelupScore()) {
                    this.jbt = cDt.getLevelupScore();
                }
                if (cDt.getLevelupScore() != 0) {
                    f = this.jbt / cDt.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), frsMemberHeaderViewHolder.jbD, scaleAnimation, null);
            }
        }
        return view;
    }

    private void bVt() {
        if (this.mPageContext != null) {
            this.fpO = new LikeModel(this.mPageContext);
            this.fpO.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.forumMember.member.g.2
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (!(obj instanceof w) || g.this.fpO.getErrorCode() != 0) {
                        if (AntiHelper.bP(g.this.fpO.getErrorCode(), g.this.fpO.getErrorString())) {
                            AntiHelper.bs(g.this.mPageContext.getPageActivity(), g.this.fpO.getErrorString());
                            return;
                        } else {
                            g.this.mPageContext.showToast(g.this.fpO.getErrorString());
                            return;
                        }
                    }
                    w wVar = (w) obj;
                    wVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                }
            });
        }
    }

    private int[] zG(int i) {
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
