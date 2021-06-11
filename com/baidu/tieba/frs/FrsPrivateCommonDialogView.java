package com.baidu.tieba.frs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.m0.r.d0.b;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsPrivateCommonDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15189e;

    /* renamed from: f  reason: collision with root package name */
    public Context f15190f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f15191g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15192h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f15193i;
    public TextView j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public TextView n;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.f15190f = context;
        b(context);
    }

    private void setImageAttribute(TbImageView tbImageView) {
        int k;
        int g2 = l.g(this.f15190f, R.dimen.tbds44);
        if (UtilHelper.getRealScreenOrientation(this.f15190f) == 2) {
            k = l.i(this.f15190f);
        } else {
            k = l.k(this.f15190f);
        }
        int i2 = k - (g2 * 2);
        ViewGroup.LayoutParams layoutParams = this.f15191g.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = (i2 * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(l.g(this.f15190f, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }

    private void setTextAttribute(List<TextView> list) {
        for (TextView textView : list) {
            Drawable drawable = textView.getCompoundDrawables()[1];
            int g2 = l.g(this.f15190f, R.dimen.tbds78);
            drawable.setBounds(0, 0, g2, g2);
            textView.setCompoundDrawables(null, drawable, null, null);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        }
    }

    public boolean a(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData != null && privateForumPopInfoData.y() != null) {
            String str = privateForumPopInfoData.y() + "_" + privateForumPopInfoData.x();
            if (b.j().g(str, false)) {
                return false;
            }
            b.j().t(str, true);
            if (privateForumPopInfoData.y().equals("task_complete")) {
                this.k.setVisibility(0);
                this.j.setVisibility(8);
            } else {
                this.k.setVisibility(8);
                this.j.setVisibility(0);
            }
            if (privateForumPopInfoData.y().equals("create_success")) {
                this.f15192h.setVisibility(0);
                this.f15192h.setText(R.string.frs_private_create_title);
                this.j.setText(R.string.frs_private_create_button);
                SkinManager.setImageResource(this.f15191g, R.drawable.pic_frs_private_create_success);
            } else if (privateForumPopInfoData.y().equals("left_time")) {
                this.f15192h.setVisibility(8);
                this.j.setText(R.string.frs_private_create_button);
                SkinManager.setImageResource(this.f15191g, R.drawable.pic_frs_private_target_remind);
            } else if (privateForumPopInfoData.y().equals("clear_forum")) {
                this.f15192h.setVisibility(8);
                this.j.setText(R.string.frs_private_fail_button);
                SkinManager.setImageResource(this.f15191g, R.drawable.pic_frs_private_target_fail);
            } else if (privateForumPopInfoData.y().equals("task_complete")) {
                this.f15192h.setVisibility(0);
                this.f15192h.setText(R.string.frs_private_success_title);
                SkinManager.setImageResource(this.f15191g, R.drawable.pic_frs_private_target_success);
            }
            this.f15193i.setText(privateForumPopInfoData.w());
            return true;
        }
        return false;
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_private_common);
        this.f15189e = linearLayout;
        this.f15191g = (TbImageView) linearLayout.findViewById(R.id.frs_private_common_image);
        this.f15192h = (TextView) this.f15189e.findViewById(R.id.frs_private_common_title);
        this.f15193i = (TextView) this.f15189e.findViewById(R.id.frs_private_common_hint);
        this.j = (TextView) this.f15189e.findViewById(R.id.frs_private_common_button);
        this.k = (RelativeLayout) this.f15189e.findViewById(R.id.frs_private_common_tips);
        this.l = (TextView) this.f15189e.findViewById(R.id.frs_private_center_tip);
        this.m = (TextView) this.f15189e.findViewById(R.id.frs_private_left_tip);
        this.n = (TextView) this.f15189e.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.f15191g);
        setTextAttribute(Arrays.asList(this.l, this.m, this.n));
        SkinManager.setBackgroundResource(this.f15189e, R.drawable.bg_frs_private_dialog);
        SkinManager.setViewTextColor(this.f15192h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f15193i, R.color.CAM_X0107);
        SkinManager.setBackgroundResourceSelector(this.j, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.j.setOnClickListener(onClickListener);
        }
    }
}
