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
/* loaded from: classes7.dex */
public class g extends com.baidu.tieba.frs.k<h, FrsMemberHeaderViewHolder> {
    private LikeModel fle;
    private int hMG;
    private int iWM;
    private View.OnClickListener mClickListener;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.hMG = 0;
        this.iWM = 0;
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
                                g.this.fle.gq(hVar.getForumName(), forumId);
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
        if (this.fle == null) {
            bRB();
        }
        return new FrsMemberHeaderViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, FrsMemberHeaderViewHolder frsMemberHeaderViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) hVar, (h) frsMemberHeaderViewHolder);
        if (hVar != null && hVar.czB() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = ao.getColor(R.color.CAM_X0109);
            w czB = hVar.czB();
            if (TbadkCoreApplication.isLogin()) {
                if (czB.isLike() == 1) {
                    frsMemberHeaderViewHolder.iWQ.setVisibility(8);
                    frsMemberHeaderViewHolder.iWR.setVisibility(0);
                    frsMemberHeaderViewHolder.iWR.setText(R.string.mydegree);
                    ao.setImageResource(frsMemberHeaderViewHolder.iVP, BitmapHelper.getSmallGradeResourceIdNew(czB.bKd()));
                    if (StringUtils.isNull(czB.getLevelName())) {
                        frsMemberHeaderViewHolder.iVQ.setVisibility(8);
                    } else {
                        frsMemberHeaderViewHolder.iVQ.setText(czB.getLevelName());
                        frsMemberHeaderViewHolder.iVQ.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(czB.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + czB.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    frsMemberHeaderViewHolder.fei.setText(spannableStringBuilder);
                    frsMemberHeaderViewHolder.fei.setVisibility(0);
                    frsMemberHeaderViewHolder.iWW.setVisibility(0);
                    frsMemberHeaderViewHolder.iWX.setVisibility(0);
                } else {
                    frsMemberHeaderViewHolder.iWQ.setVisibility(0);
                    frsMemberHeaderViewHolder.iWR.setVisibility(8);
                    frsMemberHeaderViewHolder.iVP.setVisibility(8);
                    frsMemberHeaderViewHolder.iVQ.setVisibility(8);
                    frsMemberHeaderViewHolder.fei.setVisibility(8);
                    frsMemberHeaderViewHolder.iWW.setVisibility(8);
                    frsMemberHeaderViewHolder.iWX.setVisibility(8);
                }
            } else {
                frsMemberHeaderViewHolder.iWQ.setVisibility(8);
                frsMemberHeaderViewHolder.iWR.setVisibility(8);
                frsMemberHeaderViewHolder.iVP.setVisibility(8);
                frsMemberHeaderViewHolder.iVQ.setVisibility(8);
                frsMemberHeaderViewHolder.fei.setVisibility(8);
                frsMemberHeaderViewHolder.iWW.setVisibility(8);
                frsMemberHeaderViewHolder.iWX.setVisibility(8);
            }
            frsMemberHeaderViewHolder.iWQ.setTag(Integer.valueOf(i));
            frsMemberHeaderViewHolder.iVQ.setTag(Integer.valueOf(i));
            frsMemberHeaderViewHolder.iVQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            ao.setBackgroundColor(frsMemberHeaderViewHolder.iWT, R.color.CAM_X0201);
            ao.setBackgroundColor(frsMemberHeaderViewHolder.dyW, R.color.CAM_X0204);
            ao.setBackgroundColor(frsMemberHeaderViewHolder.iWU, R.color.CAM_X0204);
            ao.setBackgroundResource(frsMemberHeaderViewHolder.iWQ, R.drawable.frs_btn_like);
            ao.setViewTextColor(frsMemberHeaderViewHolder.iWQ, R.color.white_alpha100, 1);
            ao.setViewTextColor(frsMemberHeaderViewHolder.iWR, R.color.CAM_X0105, 1);
            ao.setViewTextColor(frsMemberHeaderViewHolder.iVQ, R.color.CAM_X0109, 1);
            ao.setViewTextColor(frsMemberHeaderViewHolder.iWV, R.color.CAM_X0105, 1);
            ao.setBackgroundResource(frsMemberHeaderViewHolder.iWW, R.drawable.forum_member_exp_progress);
            ao.setBackgroundColor(frsMemberHeaderViewHolder.iWX, R.color.CAM_X0204);
            if (this.hMG != czB.bKd() || this.iWM != czB.getCurScore()) {
                this.hMG = czB.bKd();
                this.iWM = czB.getCurScore();
                frsMemberHeaderViewHolder.iWW.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ya(this.hMG)));
                float f = 0.0f;
                this.iWM = czB.getCurScore();
                if (this.iWM > czB.getLevelupScore()) {
                    this.iWM = czB.getLevelupScore();
                }
                if (czB.getLevelupScore() != 0) {
                    f = this.iWM / czB.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), frsMemberHeaderViewHolder.iWW, scaleAnimation, null);
            }
        }
        return view;
    }

    private void bRB() {
        if (this.mPageContext != null) {
            this.fle = new LikeModel(this.mPageContext);
            this.fle.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.forumMember.member.g.2
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (!(obj instanceof w) || g.this.fle.getErrorCode() != 0) {
                        if (AntiHelper.bQ(g.this.fle.getErrorCode(), g.this.fle.getErrorString())) {
                            AntiHelper.bs(g.this.mPageContext.getPageActivity(), g.this.fle.getErrorString());
                            return;
                        } else {
                            g.this.mPageContext.showToast(g.this.fle.getErrorString());
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

    private int[] ya(int i) {
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
