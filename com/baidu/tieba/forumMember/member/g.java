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
    private int hRa;
    private int jct;
    private View.OnClickListener mClickListener;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.hRa = 0;
        this.jct = 0;
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
                                g.this.fnw.gw(hVar.getForumName(), forumId);
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
            bSe();
        }
        return new FrsMemberHeaderViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, FrsMemberHeaderViewHolder frsMemberHeaderViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) hVar, (h) frsMemberHeaderViewHolder);
        if (hVar != null && hVar.cAM() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = ap.getColor(R.color.CAM_X0109);
            w cAM = hVar.cAM();
            if (TbadkCoreApplication.isLogin()) {
                if (cAM.isLike() == 1) {
                    frsMemberHeaderViewHolder.jcx.setVisibility(8);
                    frsMemberHeaderViewHolder.jcy.setVisibility(0);
                    frsMemberHeaderViewHolder.jcy.setText(R.string.mydegree);
                    ap.setImageResource(frsMemberHeaderViewHolder.jbw, BitmapHelper.getSmallGradeResourceIdNew(cAM.bKx()));
                    if (StringUtils.isNull(cAM.getLevelName())) {
                        frsMemberHeaderViewHolder.jbx.setVisibility(8);
                    } else {
                        frsMemberHeaderViewHolder.jbx.setText(cAM.getLevelName());
                        frsMemberHeaderViewHolder.jbx.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(cAM.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + cAM.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    frsMemberHeaderViewHolder.fgx.setText(spannableStringBuilder);
                    frsMemberHeaderViewHolder.fgx.setVisibility(0);
                    frsMemberHeaderViewHolder.jcD.setVisibility(0);
                    frsMemberHeaderViewHolder.jcE.setVisibility(0);
                } else {
                    frsMemberHeaderViewHolder.jcx.setVisibility(0);
                    frsMemberHeaderViewHolder.jcy.setVisibility(8);
                    frsMemberHeaderViewHolder.jbw.setVisibility(8);
                    frsMemberHeaderViewHolder.jbx.setVisibility(8);
                    frsMemberHeaderViewHolder.fgx.setVisibility(8);
                    frsMemberHeaderViewHolder.jcD.setVisibility(8);
                    frsMemberHeaderViewHolder.jcE.setVisibility(8);
                }
            } else {
                frsMemberHeaderViewHolder.jcx.setVisibility(8);
                frsMemberHeaderViewHolder.jcy.setVisibility(8);
                frsMemberHeaderViewHolder.jbw.setVisibility(8);
                frsMemberHeaderViewHolder.jbx.setVisibility(8);
                frsMemberHeaderViewHolder.fgx.setVisibility(8);
                frsMemberHeaderViewHolder.jcD.setVisibility(8);
                frsMemberHeaderViewHolder.jcE.setVisibility(8);
            }
            frsMemberHeaderViewHolder.jcx.setTag(Integer.valueOf(i));
            frsMemberHeaderViewHolder.jbx.setTag(Integer.valueOf(i));
            frsMemberHeaderViewHolder.jbx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            ap.setBackgroundColor(frsMemberHeaderViewHolder.jcA, R.color.CAM_X0201);
            ap.setBackgroundColor(frsMemberHeaderViewHolder.dBb, R.color.CAM_X0204);
            ap.setBackgroundColor(frsMemberHeaderViewHolder.jcB, R.color.CAM_X0204);
            ap.setBackgroundResource(frsMemberHeaderViewHolder.jcx, R.drawable.frs_btn_like);
            ap.setViewTextColor(frsMemberHeaderViewHolder.jcx, R.color.white_alpha100, 1);
            ap.setViewTextColor(frsMemberHeaderViewHolder.jcy, R.color.CAM_X0105, 1);
            ap.setViewTextColor(frsMemberHeaderViewHolder.jbx, R.color.CAM_X0109, 1);
            ap.setViewTextColor(frsMemberHeaderViewHolder.jcC, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(frsMemberHeaderViewHolder.jcD, R.drawable.forum_member_exp_progress);
            ap.setBackgroundColor(frsMemberHeaderViewHolder.jcE, R.color.CAM_X0204);
            if (this.hRa != cAM.bKx() || this.jct != cAM.getCurScore()) {
                this.hRa = cAM.bKx();
                this.jct = cAM.getCurScore();
                frsMemberHeaderViewHolder.jcD.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, yk(this.hRa)));
                float f = 0.0f;
                this.jct = cAM.getCurScore();
                if (this.jct > cAM.getLevelupScore()) {
                    this.jct = cAM.getLevelupScore();
                }
                if (cAM.getLevelupScore() != 0) {
                    f = this.jct / cAM.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), frsMemberHeaderViewHolder.jcD, scaleAnimation, null);
            }
        }
        return view;
    }

    private void bSe() {
        if (this.mPageContext != null) {
            this.fnw = new LikeModel(this.mPageContext);
            this.fnw.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.forumMember.member.g.2
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (!(obj instanceof w) || g.this.fnw.getErrorCode() != 0) {
                        if (AntiHelper.bX(g.this.fnw.getErrorCode(), g.this.fnw.getErrorString())) {
                            AntiHelper.br(g.this.mPageContext.getPageActivity(), g.this.fnw.getErrorString());
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
