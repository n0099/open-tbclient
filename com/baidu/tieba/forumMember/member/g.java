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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes8.dex */
public class g extends com.baidu.tieba.frs.k<h, FrsMemberHeaderViewHolder> {
    private LikeModel fnw;
    private int hRo;
    private int jcH;
    private View.OnClickListener mClickListener;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.hRo = 0;
        this.jcH = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.n item = g.this.getItem(((Integer) tag).intValue());
                    if (item instanceof h) {
                        h hVar = (h) item;
                        if (view.getId() == R.id.like_btn) {
                            if (bh.checkUpIsLogin(g.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    g.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = hVar.getForumId();
                                g.this.fnw.gy(hVar.getForumName(), forumId);
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
        if (this.fnw == null) {
            bSl();
        }
        return new FrsMemberHeaderViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, FrsMemberHeaderViewHolder frsMemberHeaderViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) hVar, (h) frsMemberHeaderViewHolder);
        if (hVar != null && hVar.cAT() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = ap.getColor(R.color.CAM_X0109);
            w cAT = hVar.cAT();
            if (TbadkCoreApplication.isLogin()) {
                if (cAT.isLike() == 1) {
                    frsMemberHeaderViewHolder.jcL.setVisibility(8);
                    frsMemberHeaderViewHolder.jcM.setVisibility(0);
                    frsMemberHeaderViewHolder.jcM.setText(R.string.mydegree);
                    ap.setImageResource(frsMemberHeaderViewHolder.jbK, BitmapHelper.getSmallGradeResourceIdNew(cAT.bKC()));
                    if (StringUtils.isNull(cAT.getLevelName())) {
                        frsMemberHeaderViewHolder.jbL.setVisibility(8);
                    } else {
                        frsMemberHeaderViewHolder.jbL.setText(cAT.getLevelName());
                        frsMemberHeaderViewHolder.jbL.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(cAT.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + cAT.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    frsMemberHeaderViewHolder.fgx.setText(spannableStringBuilder);
                    frsMemberHeaderViewHolder.fgx.setVisibility(0);
                    frsMemberHeaderViewHolder.jcR.setVisibility(0);
                    frsMemberHeaderViewHolder.jcS.setVisibility(0);
                } else {
                    frsMemberHeaderViewHolder.jcL.setVisibility(0);
                    frsMemberHeaderViewHolder.jcM.setVisibility(8);
                    frsMemberHeaderViewHolder.jbK.setVisibility(8);
                    frsMemberHeaderViewHolder.jbL.setVisibility(8);
                    frsMemberHeaderViewHolder.fgx.setVisibility(8);
                    frsMemberHeaderViewHolder.jcR.setVisibility(8);
                    frsMemberHeaderViewHolder.jcS.setVisibility(8);
                }
            } else {
                frsMemberHeaderViewHolder.jcL.setVisibility(8);
                frsMemberHeaderViewHolder.jcM.setVisibility(8);
                frsMemberHeaderViewHolder.jbK.setVisibility(8);
                frsMemberHeaderViewHolder.jbL.setVisibility(8);
                frsMemberHeaderViewHolder.fgx.setVisibility(8);
                frsMemberHeaderViewHolder.jcR.setVisibility(8);
                frsMemberHeaderViewHolder.jcS.setVisibility(8);
            }
            frsMemberHeaderViewHolder.jcL.setTag(Integer.valueOf(i));
            frsMemberHeaderViewHolder.jbL.setTag(Integer.valueOf(i));
            frsMemberHeaderViewHolder.jbL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            ap.setBackgroundColor(frsMemberHeaderViewHolder.jcO, R.color.CAM_X0201);
            ap.setBackgroundColor(frsMemberHeaderViewHolder.dBb, R.color.CAM_X0204);
            ap.setBackgroundColor(frsMemberHeaderViewHolder.jcP, R.color.CAM_X0204);
            ap.setBackgroundResource(frsMemberHeaderViewHolder.jcL, R.drawable.frs_btn_like);
            ap.setViewTextColor(frsMemberHeaderViewHolder.jcL, R.color.white_alpha100, 1);
            ap.setViewTextColor(frsMemberHeaderViewHolder.jcM, R.color.CAM_X0105, 1);
            ap.setViewTextColor(frsMemberHeaderViewHolder.jbL, R.color.CAM_X0109, 1);
            ap.setViewTextColor(frsMemberHeaderViewHolder.jcQ, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(frsMemberHeaderViewHolder.jcR, R.drawable.forum_member_exp_progress);
            ap.setBackgroundColor(frsMemberHeaderViewHolder.jcS, R.color.CAM_X0204);
            if (this.hRo != cAT.bKC() || this.jcH != cAT.getCurScore()) {
                this.hRo = cAT.bKC();
                this.jcH = cAT.getCurScore();
                frsMemberHeaderViewHolder.jcR.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, yk(this.hRo)));
                float f = 0.0f;
                this.jcH = cAT.getCurScore();
                if (this.jcH > cAT.getLevelupScore()) {
                    this.jcH = cAT.getLevelupScore();
                }
                if (cAT.getLevelupScore() != 0) {
                    f = this.jcH / cAT.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), frsMemberHeaderViewHolder.jcR, scaleAnimation, null);
            }
        }
        return view;
    }

    private void bSl() {
        if (this.mPageContext != null) {
            this.fnw = new LikeModel(this.mPageContext);
            this.fnw.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.forumMember.member.g.2
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (!(obj instanceof w) || g.this.fnw.getErrorCode() != 0) {
                        if (AntiHelper.bX(g.this.fnw.getErrorCode(), g.this.fnw.getErrorString())) {
                            AntiHelper.bq(g.this.mPageContext.getPageActivity(), g.this.fnw.getErrorString());
                            return;
                        } else {
                            g.this.mPageContext.showToast(g.this.fnw.getErrorString());
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

    private int[] yk(int i) {
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
