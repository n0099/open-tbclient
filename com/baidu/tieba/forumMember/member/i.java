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
/* loaded from: classes17.dex */
public class i extends com.baidu.tieba.frs.k<j, k> {
    private LikeModel exb;
    private int gLS;
    private int hPf;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.gLS = 0;
        this.hPf = 0;
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
                                i.this.exb.fR(jVar.getForumName(), forumId);
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
    /* renamed from: bb */
    public k b(ViewGroup viewGroup) {
        if (this.exb == null) {
            bGF();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) kVar);
        if (jVar != null && jVar.ckn() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = ap.getColor(R.color.cp_cont_d);
            v ckn = jVar.ckn();
            if (TbadkCoreApplication.isLogin()) {
                if (ckn.isLike() == 1) {
                    kVar.hPj.setVisibility(8);
                    kVar.hPk.setVisibility(0);
                    kVar.hPk.setText(R.string.mydegree);
                    ap.setImageResource(kVar.hOi, BitmapHelper.getSmallGradeResourceIdNew(ckn.dua()));
                    if (StringUtils.isNull(ckn.getLevelName())) {
                        kVar.hOj.setVisibility(8);
                    } else {
                        kVar.hOj.setText(ckn.getLevelName());
                        kVar.hOj.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(ckn.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + ckn.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.equ.setText(spannableStringBuilder);
                    kVar.equ.setVisibility(0);
                    kVar.hPp.setVisibility(0);
                    kVar.hPq.setVisibility(0);
                } else {
                    kVar.hPj.setVisibility(0);
                    kVar.hPk.setVisibility(8);
                    kVar.hOi.setVisibility(8);
                    kVar.hOj.setVisibility(8);
                    kVar.equ.setVisibility(8);
                    kVar.hPp.setVisibility(8);
                    kVar.hPq.setVisibility(8);
                }
            } else {
                kVar.hPj.setVisibility(8);
                kVar.hPk.setVisibility(8);
                kVar.hOi.setVisibility(8);
                kVar.hOj.setVisibility(8);
                kVar.equ.setVisibility(8);
                kVar.hPp.setVisibility(8);
                kVar.hPq.setVisibility(8);
            }
            kVar.hPj.setTag(Integer.valueOf(i));
            kVar.hOj.setTag(Integer.valueOf(i));
            kVar.hOj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            ap.setBackgroundColor(kVar.hPm, R.color.cp_bg_line_d);
            ap.setBackgroundColor(kVar.mDivider, R.color.cp_bg_line_c);
            ap.setBackgroundColor(kVar.hPn, R.color.cp_bg_line_c);
            ap.setBackgroundResource(kVar.hPj, R.drawable.frs_btn_like);
            ap.setViewTextColor(kVar.hPj, R.color.white_alpha100, 1);
            ap.setViewTextColor(kVar.hPk, R.color.cp_cont_b, 1);
            ap.setViewTextColor(kVar.hOj, R.color.cp_cont_d, 1);
            ap.setViewTextColor(kVar.hPo, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(kVar.hPp, R.drawable.forum_member_exp_progress);
            ap.setBackgroundColor(kVar.hPq, R.color.cp_bg_line_c);
            if (this.gLS != ckn.dua() || this.hPf != ckn.getCurScore()) {
                this.gLS = ckn.dua();
                this.hPf = ckn.getCurScore();
                kVar.hPp.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, wF(this.gLS)));
                float f = 0.0f;
                this.hPf = ckn.getCurScore();
                if (this.hPf > ckn.getLevelupScore()) {
                    this.hPf = ckn.getLevelupScore();
                }
                if (ckn.getLevelupScore() != 0) {
                    f = this.hPf / ckn.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.hPp, scaleAnimation, null);
            }
        }
        return view;
    }

    private void bGF() {
        if (this.mPageContext != null) {
            this.exb = new LikeModel(this.mPageContext);
            this.exb.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (!(obj instanceof v) || i.this.exb.getErrorCode() != 0) {
                        if (AntiHelper.by(i.this.exb.getErrorCode(), i.this.exb.getErrorString())) {
                            AntiHelper.bb(i.this.mPageContext.getPageActivity(), i.this.exb.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.exb.getErrorString());
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

    private int[] wF(int i) {
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
