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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes23.dex */
public class i extends com.baidu.tieba.frs.k<j, k> {
    private LikeModel eTL;
    private int hqc;
    private int ixC;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.hqc = 0;
        this.ixC = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.q item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == R.id.like_btn) {
                            if (bg.checkUpIsLogin(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    i.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.eTL.gp(jVar.getForumName(), forumId);
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
    /* renamed from: be */
    public k c(ViewGroup viewGroup) {
        if (this.eTL == null) {
            bNj();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) kVar);
        if (jVar != null && jVar.cuf() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = ap.getColor(R.color.cp_cont_d);
            v cuf = jVar.cuf();
            if (TbadkCoreApplication.isLogin()) {
                if (cuf.isLike() == 1) {
                    kVar.ixG.setVisibility(8);
                    kVar.ixH.setVisibility(0);
                    kVar.ixH.setText(R.string.mydegree);
                    ap.setImageResource(kVar.iwF, BitmapHelper.getSmallGradeResourceIdNew(cuf.dEM()));
                    if (StringUtils.isNull(cuf.getLevelName())) {
                        kVar.iwG.setVisibility(8);
                    } else {
                        kVar.iwG.setText(cuf.getLevelName());
                        kVar.iwG.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(cuf.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + cuf.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.eNg.setText(spannableStringBuilder);
                    kVar.eNg.setVisibility(0);
                    kVar.ixM.setVisibility(0);
                    kVar.ixN.setVisibility(0);
                } else {
                    kVar.ixG.setVisibility(0);
                    kVar.ixH.setVisibility(8);
                    kVar.iwF.setVisibility(8);
                    kVar.iwG.setVisibility(8);
                    kVar.eNg.setVisibility(8);
                    kVar.ixM.setVisibility(8);
                    kVar.ixN.setVisibility(8);
                }
            } else {
                kVar.ixG.setVisibility(8);
                kVar.ixH.setVisibility(8);
                kVar.iwF.setVisibility(8);
                kVar.iwG.setVisibility(8);
                kVar.eNg.setVisibility(8);
                kVar.ixM.setVisibility(8);
                kVar.ixN.setVisibility(8);
            }
            kVar.ixG.setTag(Integer.valueOf(i));
            kVar.iwG.setTag(Integer.valueOf(i));
            kVar.iwG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            ap.setBackgroundColor(kVar.ixJ, R.color.cp_bg_line_d);
            ap.setBackgroundColor(kVar.mDivider, R.color.cp_bg_line_c);
            ap.setBackgroundColor(kVar.ixK, R.color.cp_bg_line_c);
            ap.setBackgroundResource(kVar.ixG, R.drawable.frs_btn_like);
            ap.setViewTextColor(kVar.ixG, R.color.white_alpha100, 1);
            ap.setViewTextColor(kVar.ixH, R.color.cp_cont_b, 1);
            ap.setViewTextColor(kVar.iwG, R.color.cp_cont_d, 1);
            ap.setViewTextColor(kVar.ixL, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(kVar.ixM, R.drawable.forum_member_exp_progress);
            ap.setBackgroundColor(kVar.ixN, R.color.cp_bg_line_c);
            if (this.hqc != cuf.dEM() || this.ixC != cuf.getCurScore()) {
                this.hqc = cuf.dEM();
                this.ixC = cuf.getCurScore();
                kVar.ixM.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, yd(this.hqc)));
                float f = 0.0f;
                this.ixC = cuf.getCurScore();
                if (this.ixC > cuf.getLevelupScore()) {
                    this.ixC = cuf.getLevelupScore();
                }
                if (cuf.getLevelupScore() != 0) {
                    f = this.ixC / cuf.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.ixM, scaleAnimation, null);
            }
        }
        return view;
    }

    private void bNj() {
        if (this.mPageContext != null) {
            this.eTL = new LikeModel(this.mPageContext);
            this.eTL.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (!(obj instanceof v) || i.this.eTL.getErrorCode() != 0) {
                        if (AntiHelper.bN(i.this.eTL.getErrorCode(), i.this.eTL.getErrorString())) {
                            AntiHelper.bm(i.this.mPageContext.getPageActivity(), i.this.eTL.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.eTL.getErrorString());
                            return;
                        }
                    }
                    v vVar = (v) obj;
                    vVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                }
            });
        }
    }

    private int[] yd(int i) {
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
