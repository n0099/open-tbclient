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
/* loaded from: classes7.dex */
public class i extends com.baidu.tieba.frs.h<j, k> {
    private LikeModel dfB;
    private int fgO;
    private int gfz;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.fgO = 0;
        this.gfz = 0;
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
                                i.this.dfB.er(jVar.getForumName(), forumId);
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
    /* renamed from: aC */
    public k b(ViewGroup viewGroup) {
        if (this.dfB == null) {
            bas();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) kVar);
        if (jVar != null && jVar.bzR() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = am.getColor(R.color.cp_cont_d);
            com.baidu.tieba.tbadkCore.t bzR = jVar.bzR();
            if (TbadkCoreApplication.isLogin()) {
                if (bzR.isLike() == 1) {
                    kVar.gfD.setVisibility(8);
                    kVar.gfE.setVisibility(0);
                    kVar.gfE.setText(R.string.mydegree);
                    am.setImageResource(kVar.geB, BitmapHelper.getSmallGradeResourceIdNew(bzR.cFY()));
                    if (StringUtils.isNull(bzR.getLevelName())) {
                        kVar.geC.setVisibility(8);
                    } else {
                        kVar.geC.setText(bzR.getLevelName());
                        kVar.geC.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(bzR.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + bzR.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.gfG.setText(spannableStringBuilder);
                    kVar.gfG.setVisibility(0);
                    kVar.gfK.setVisibility(0);
                    kVar.gfL.setVisibility(0);
                } else {
                    kVar.gfD.setVisibility(0);
                    kVar.gfE.setVisibility(8);
                    kVar.geB.setVisibility(8);
                    kVar.geC.setVisibility(8);
                    kVar.gfG.setVisibility(8);
                    kVar.gfK.setVisibility(8);
                    kVar.gfL.setVisibility(8);
                }
            } else {
                kVar.gfD.setVisibility(8);
                kVar.gfE.setVisibility(8);
                kVar.geB.setVisibility(8);
                kVar.geC.setVisibility(8);
                kVar.gfG.setVisibility(8);
                kVar.gfK.setVisibility(8);
                kVar.gfL.setVisibility(8);
            }
            kVar.gfD.setTag(Integer.valueOf(i));
            kVar.geC.setTag(Integer.valueOf(i));
            kVar.geC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            am.setBackgroundColor(kVar.gfH, R.color.cp_bg_line_d);
            am.setBackgroundColor(kVar.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(kVar.gfI, R.color.cp_bg_line_c);
            am.setBackgroundResource(kVar.gfD, R.drawable.frs_btn_like);
            am.setViewTextColor(kVar.gfD, R.color.white_alpha100, 1);
            am.setViewTextColor(kVar.gfE, R.color.cp_cont_b, 1);
            am.setViewTextColor(kVar.geC, R.color.cp_cont_d, 1);
            am.setViewTextColor(kVar.gfJ, R.color.cp_cont_b, 1);
            am.setBackgroundResource(kVar.gfK, R.drawable.forum_member_exp_progress);
            am.setBackgroundColor(kVar.gfL, R.color.cp_bg_line_c);
            if (this.fgO != bzR.cFY() || this.gfz != bzR.getCurScore()) {
                this.fgO = bzR.cFY();
                this.gfz = bzR.getCurScore();
                kVar.gfK.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, sg(this.fgO)));
                float f = 0.0f;
                this.gfz = bzR.getCurScore();
                if (this.gfz > bzR.getLevelupScore()) {
                    this.gfz = bzR.getLevelupScore();
                }
                if (bzR.getLevelupScore() != 0) {
                    f = this.gfz / bzR.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.gfK, scaleAnimation, null);
            }
        }
        return view;
    }

    private void bas() {
        if (this.mPageContext != null) {
            this.dfB = new LikeModel(this.mPageContext);
            this.dfB.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (!(obj instanceof com.baidu.tieba.tbadkCore.t) || i.this.dfB.getErrorCode() != 0) {
                        if (AntiHelper.aW(i.this.dfB.getErrorCode(), i.this.dfB.getErrorString())) {
                            AntiHelper.bj(i.this.mPageContext.getPageActivity(), i.this.dfB.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.dfB.getErrorString());
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

    private int[] sg(int i) {
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
