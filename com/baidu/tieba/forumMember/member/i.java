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
    private LikeModel dYI;
    private int ggN;
    private int hjF;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.ggN = 0;
        this.hjF = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.o item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == R.id.like_btn) {
                            if (bc.checkUpIsLogin(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    i.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.dYI.fq(jVar.getForumName(), forumId);
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
    /* renamed from: aX */
    public k b(ViewGroup viewGroup) {
        if (this.dYI == null) {
            brx();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) kVar);
        if (jVar != null && jVar.bTy() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = am.getColor(R.color.cp_cont_d);
            u bTy = jVar.bTy();
            if (TbadkCoreApplication.isLogin()) {
                if (bTy.isLike() == 1) {
                    kVar.hjJ.setVisibility(8);
                    kVar.hjK.setVisibility(0);
                    kVar.hjK.setText(R.string.mydegree);
                    am.setImageResource(kVar.hiH, BitmapHelper.getSmallGradeResourceIdNew(bTy.daK()));
                    if (StringUtils.isNull(bTy.getLevelName())) {
                        kVar.hiI.setVisibility(8);
                    } else {
                        kVar.hiI.setText(bTy.getLevelName());
                        kVar.hiI.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(bTy.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + bTy.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.hjM.setText(spannableStringBuilder);
                    kVar.hjM.setVisibility(0);
                    kVar.hjQ.setVisibility(0);
                    kVar.hjR.setVisibility(0);
                } else {
                    kVar.hjJ.setVisibility(0);
                    kVar.hjK.setVisibility(8);
                    kVar.hiH.setVisibility(8);
                    kVar.hiI.setVisibility(8);
                    kVar.hjM.setVisibility(8);
                    kVar.hjQ.setVisibility(8);
                    kVar.hjR.setVisibility(8);
                }
            } else {
                kVar.hjJ.setVisibility(8);
                kVar.hjK.setVisibility(8);
                kVar.hiH.setVisibility(8);
                kVar.hiI.setVisibility(8);
                kVar.hjM.setVisibility(8);
                kVar.hjQ.setVisibility(8);
                kVar.hjR.setVisibility(8);
            }
            kVar.hjJ.setTag(Integer.valueOf(i));
            kVar.hiI.setTag(Integer.valueOf(i));
            kVar.hiI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            am.setBackgroundColor(kVar.hjN, R.color.cp_bg_line_d);
            am.setBackgroundColor(kVar.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(kVar.hjO, R.color.cp_bg_line_c);
            am.setBackgroundResource(kVar.hjJ, R.drawable.frs_btn_like);
            am.setViewTextColor(kVar.hjJ, R.color.white_alpha100, 1);
            am.setViewTextColor(kVar.hjK, R.color.cp_cont_b, 1);
            am.setViewTextColor(kVar.hiI, R.color.cp_cont_d, 1);
            am.setViewTextColor(kVar.hjP, R.color.cp_cont_b, 1);
            am.setBackgroundResource(kVar.hjQ, R.drawable.forum_member_exp_progress);
            am.setBackgroundColor(kVar.hjR, R.color.cp_bg_line_c);
            if (this.ggN != bTy.daK() || this.hjF != bTy.getCurScore()) {
                this.ggN = bTy.daK();
                this.hjF = bTy.getCurScore();
                kVar.hjQ.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, tv(this.ggN)));
                float f = 0.0f;
                this.hjF = bTy.getCurScore();
                if (this.hjF > bTy.getLevelupScore()) {
                    this.hjF = bTy.getLevelupScore();
                }
                if (bTy.getLevelupScore() != 0) {
                    f = this.hjF / bTy.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.hjQ, scaleAnimation, null);
            }
        }
        return view;
    }

    private void brx() {
        if (this.mPageContext != null) {
            this.dYI = new LikeModel(this.mPageContext);
            this.dYI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (!(obj instanceof u) || i.this.dYI.getErrorCode() != 0) {
                        if (AntiHelper.bv(i.this.dYI.getErrorCode(), i.this.dYI.getErrorString())) {
                            AntiHelper.aX(i.this.mPageContext.getPageActivity(), i.this.dYI.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.dYI.getErrorString());
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

    private int[] tv(int i) {
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
