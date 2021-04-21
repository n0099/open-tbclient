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
import d.b.c.e.p.l;
import d.b.i0.r.d0.b;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsPrivateCommonDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15745e;

    /* renamed from: f  reason: collision with root package name */
    public Context f15746f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f15747g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15748h;
    public TextView i;
    public TextView j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public TextView n;

    public FrsPrivateCommonDialogView(Context context) {
        super(context);
        this.f15746f = context;
        b(context);
    }

    private void setImageAttribute(TbImageView tbImageView) {
        int k;
        int g2 = l.g(this.f15746f, R.dimen.tbds44);
        if (UtilHelper.getRealScreenOrientation(this.f15746f) == 2) {
            k = l.i(this.f15746f);
        } else {
            k = l.k(this.f15746f);
        }
        int i = k - (g2 * 2);
        ViewGroup.LayoutParams layoutParams = this.f15747g.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = (i * 21) / 38;
        tbImageView.setLayoutParams(layoutParams);
        tbImageView.setRadius(l.g(this.f15746f, R.dimen.tbds30));
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
    }

    private void setTextAttribute(List<TextView> list) {
        for (TextView textView : list) {
            Drawable drawable = textView.getCompoundDrawables()[1];
            int g2 = l.g(this.f15746f, R.dimen.tbds78);
            drawable.setBounds(0, 0, g2, g2);
            textView.setCompoundDrawables(null, drawable, null, null);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        }
    }

    public boolean a(PrivateForumPopInfoData privateForumPopInfoData) {
        if (privateForumPopInfoData != null && privateForumPopInfoData.u() != null) {
            String str = privateForumPopInfoData.u() + "_" + privateForumPopInfoData.t();
            if (b.j().g(str, false)) {
                return false;
            }
            b.j().t(str, true);
            if (privateForumPopInfoData.u().equals("task_complete")) {
                this.k.setVisibility(0);
                this.j.setVisibility(8);
            } else {
                this.k.setVisibility(8);
                this.j.setVisibility(0);
            }
            if (privateForumPopInfoData.u().equals("create_success")) {
                this.f15748h.setVisibility(0);
                this.f15748h.setText(R.string.frs_private_create_title);
                this.j.setText(R.string.frs_private_create_button);
                SkinManager.setImageResource(this.f15747g, R.drawable.pic_frs_private_create_success);
            } else if (privateForumPopInfoData.u().equals("left_time")) {
                this.f15748h.setVisibility(8);
                this.j.setText(R.string.frs_private_create_button);
                SkinManager.setImageResource(this.f15747g, R.drawable.pic_frs_private_target_remind);
            } else if (privateForumPopInfoData.u().equals("clear_forum")) {
                this.f15748h.setVisibility(8);
                this.j.setText(R.string.frs_private_fail_button);
                SkinManager.setImageResource(this.f15747g, R.drawable.pic_frs_private_target_fail);
            } else if (privateForumPopInfoData.u().equals("task_complete")) {
                this.f15748h.setVisibility(0);
                this.f15748h.setText(R.string.frs_private_success_title);
                SkinManager.setImageResource(this.f15747g, R.drawable.pic_frs_private_target_success);
            }
            this.i.setText(privateForumPopInfoData.s());
            return true;
        }
        return false;
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_common_dialog, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_private_common);
        this.f15745e = linearLayout;
        this.f15747g = (TbImageView) linearLayout.findViewById(R.id.frs_private_common_image);
        this.f15748h = (TextView) this.f15745e.findViewById(R.id.frs_private_common_title);
        this.i = (TextView) this.f15745e.findViewById(R.id.frs_private_common_hint);
        this.j = (TextView) this.f15745e.findViewById(R.id.frs_private_common_button);
        this.k = (RelativeLayout) this.f15745e.findViewById(R.id.frs_private_common_tips);
        this.l = (TextView) this.f15745e.findViewById(R.id.frs_private_center_tip);
        this.m = (TextView) this.f15745e.findViewById(R.id.frs_private_left_tip);
        this.n = (TextView) this.f15745e.findViewById(R.id.frs_private_right_tip);
        setImageAttribute(this.f15747g);
        setTextAttribute(Arrays.asList(this.l, this.m, this.n));
        SkinManager.setBackgroundResource(this.f15745e, R.drawable.bg_frs_private_dialog);
        SkinManager.setViewTextColor(this.f15748h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107);
        SkinManager.setBackgroundResourceSelector(this.j, R.drawable.btn_frs_private_n, R.drawable.btn_frs_private_s);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0101);
    }

    public void setConfirmButton(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.j.setOnClickListener(onClickListener);
        }
    }
}
