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
/* loaded from: classes23.dex */
public class i extends com.baidu.tieba.frs.k<j, k> {
    private LikeModel fgf;
    private int hFk;
    private int iPf;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.hFk = 0;
        this.iPf = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.q item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == R.id.like_btn) {
                            if (bh.checkUpIsLogin(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    i.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.fgf.gu(jVar.getForumName(), forumId);
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
    /* renamed from: bc */
    public k c(ViewGroup viewGroup) {
        if (this.fgf == null) {
            bSN();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) kVar);
        if (jVar != null && jVar.cAy() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = ap.getColor(R.color.CAM_X0109);
            w cAy = jVar.cAy();
            if (TbadkCoreApplication.isLogin()) {
                if (cAy.isLike() == 1) {
                    kVar.iPj.setVisibility(8);
                    kVar.iPk.setVisibility(0);
                    kVar.iPk.setText(R.string.mydegree);
                    ap.setImageResource(kVar.iOj, BitmapHelper.getSmallGradeResourceIdNew(cAy.bLB()));
                    if (StringUtils.isNull(cAy.getLevelName())) {
                        kVar.iOk.setVisibility(8);
                    } else {
                        kVar.iOk.setText(cAy.getLevelName());
                        kVar.iOk.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(cAy.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + cAy.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.eZp.setText(spannableStringBuilder);
                    kVar.eZp.setVisibility(0);
                    kVar.iPp.setVisibility(0);
                    kVar.iPq.setVisibility(0);
                } else {
                    kVar.iPj.setVisibility(0);
                    kVar.iPk.setVisibility(8);
                    kVar.iOj.setVisibility(8);
                    kVar.iOk.setVisibility(8);
                    kVar.eZp.setVisibility(8);
                    kVar.iPp.setVisibility(8);
                    kVar.iPq.setVisibility(8);
                }
            } else {
                kVar.iPj.setVisibility(8);
                kVar.iPk.setVisibility(8);
                kVar.iOj.setVisibility(8);
                kVar.iOk.setVisibility(8);
                kVar.eZp.setVisibility(8);
                kVar.iPp.setVisibility(8);
                kVar.iPq.setVisibility(8);
            }
            kVar.iPj.setTag(Integer.valueOf(i));
            kVar.iOk.setTag(Integer.valueOf(i));
            kVar.iOk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            ap.setBackgroundColor(kVar.iPm, R.color.CAM_X0201);
            ap.setBackgroundColor(kVar.mDivider, R.color.CAM_X0204);
            ap.setBackgroundColor(kVar.iPn, R.color.CAM_X0204);
            ap.setBackgroundResource(kVar.iPj, R.drawable.frs_btn_like);
            ap.setViewTextColor(kVar.iPj, R.color.white_alpha100, 1);
            ap.setViewTextColor(kVar.iPk, R.color.CAM_X0105, 1);
            ap.setViewTextColor(kVar.iOk, R.color.CAM_X0109, 1);
            ap.setViewTextColor(kVar.iPo, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(kVar.iPp, R.drawable.forum_member_exp_progress);
            ap.setBackgroundColor(kVar.iPq, R.color.CAM_X0204);
            if (this.hFk != cAy.bLB() || this.iPf != cAy.getCurScore()) {
                this.hFk = cAy.bLB();
                this.iPf = cAy.getCurScore();
                kVar.iPp.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, zt(this.hFk)));
                float f = 0.0f;
                this.iPf = cAy.getCurScore();
                if (this.iPf > cAy.getLevelupScore()) {
                    this.iPf = cAy.getLevelupScore();
                }
                if (cAy.getLevelupScore() != 0) {
                    f = this.iPf / cAy.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.iPp, scaleAnimation, null);
            }
        }
        return view;
    }

    private void bSN() {
        if (this.mPageContext != null) {
            this.fgf = new LikeModel(this.mPageContext);
            this.fgf.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (!(obj instanceof w) || i.this.fgf.getErrorCode() != 0) {
                        if (AntiHelper.bP(i.this.fgf.getErrorCode(), i.this.fgf.getErrorString())) {
                            AntiHelper.bn(i.this.mPageContext.getPageActivity(), i.this.fgf.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.fgf.getErrorString());
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

    private int[] zt(int i) {
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
