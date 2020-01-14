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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes8.dex */
public class i extends com.baidu.tieba.frs.h<j, k> {
    private LikeModel dfN;
    private int fka;
    private int giJ;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.fka = 0;
        this.giJ = 0;
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
                                i.this.dfN.et(jVar.getForumName(), forumId);
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
    /* renamed from: aG */
    public k b(ViewGroup viewGroup) {
        if (this.dfN == null) {
            baN();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) kVar);
        if (jVar != null && jVar.bAT() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = am.getColor(R.color.cp_cont_d);
            com.baidu.tieba.tbadkCore.t bAT = jVar.bAT();
            if (TbadkCoreApplication.isLogin()) {
                if (bAT.isLike() == 1) {
                    kVar.giN.setVisibility(8);
                    kVar.giO.setVisibility(0);
                    kVar.giO.setText(R.string.mydegree);
                    am.setImageResource(kVar.ghK, BitmapHelper.getSmallGradeResourceIdNew(bAT.cHe()));
                    if (StringUtils.isNull(bAT.getLevelName())) {
                        kVar.ghL.setVisibility(8);
                    } else {
                        kVar.ghL.setText(bAT.getLevelName());
                        kVar.ghL.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(bAT.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + bAT.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.giQ.setText(spannableStringBuilder);
                    kVar.giQ.setVisibility(0);
                    kVar.giU.setVisibility(0);
                    kVar.giV.setVisibility(0);
                } else {
                    kVar.giN.setVisibility(0);
                    kVar.giO.setVisibility(8);
                    kVar.ghK.setVisibility(8);
                    kVar.ghL.setVisibility(8);
                    kVar.giQ.setVisibility(8);
                    kVar.giU.setVisibility(8);
                    kVar.giV.setVisibility(8);
                }
            } else {
                kVar.giN.setVisibility(8);
                kVar.giO.setVisibility(8);
                kVar.ghK.setVisibility(8);
                kVar.ghL.setVisibility(8);
                kVar.giQ.setVisibility(8);
                kVar.giU.setVisibility(8);
                kVar.giV.setVisibility(8);
            }
            kVar.giN.setTag(Integer.valueOf(i));
            kVar.ghL.setTag(Integer.valueOf(i));
            kVar.ghL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            am.setBackgroundColor(kVar.giR, R.color.cp_bg_line_d);
            am.setBackgroundColor(kVar.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(kVar.giS, R.color.cp_bg_line_c);
            am.setBackgroundResource(kVar.giN, R.drawable.frs_btn_like);
            am.setViewTextColor(kVar.giN, R.color.white_alpha100, 1);
            am.setViewTextColor(kVar.giO, R.color.cp_cont_b, 1);
            am.setViewTextColor(kVar.ghL, R.color.cp_cont_d, 1);
            am.setViewTextColor(kVar.giT, R.color.cp_cont_b, 1);
            am.setBackgroundResource(kVar.giU, R.drawable.forum_member_exp_progress);
            am.setBackgroundColor(kVar.giV, R.color.cp_bg_line_c);
            if (this.fka != bAT.cHe() || this.giJ != bAT.getCurScore()) {
                this.fka = bAT.cHe();
                this.giJ = bAT.getCurScore();
                kVar.giU.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, sl(this.fka)));
                float f = 0.0f;
                this.giJ = bAT.getCurScore();
                if (this.giJ > bAT.getLevelupScore()) {
                    this.giJ = bAT.getLevelupScore();
                }
                if (bAT.getLevelupScore() != 0) {
                    f = this.giJ / bAT.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.giU, scaleAnimation, null);
            }
        }
        return view;
    }

    private void baN() {
        if (this.mPageContext != null) {
            this.dfN = new LikeModel(this.mPageContext);
            this.dfN.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (!(obj instanceof com.baidu.tieba.tbadkCore.t) || i.this.dfN.getErrorCode() != 0) {
                        if (AntiHelper.bc(i.this.dfN.getErrorCode(), i.this.dfN.getErrorString())) {
                            AntiHelper.bn(i.this.mPageContext.getPageActivity(), i.this.dfN.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.dfN.getErrorString());
                            return;
                        }
                    }
                    com.baidu.tieba.tbadkCore.t tVar = (com.baidu.tieba.tbadkCore.t) obj;
                    tVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                }
            });
        }
    }

    private int[] sl(int i) {
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
