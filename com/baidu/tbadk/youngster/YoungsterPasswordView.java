package com.baidu.tbadk.youngster;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterVerifyActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.youngster.PasswordView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import d.b.h0.c1.b.c;
/* loaded from: classes3.dex */
public class YoungsterPasswordView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f14407e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14408f;

    /* renamed from: g  reason: collision with root package name */
    public PasswordView f14409g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14410h;
    public ImageView i;
    public LinearLayout j;
    public int k;
    public String l;
    public int m;
    public BdTopToast n;
    public PasswordView.g o;
    public CustomMessageListener p;

    /* loaded from: classes3.dex */
    public class a implements PasswordView.g {
        public a() {
        }

        @Override // com.baidu.tbadk.youngster.PasswordView.g
        public void onComplete() {
            String passWord = YoungsterPasswordView.this.f14409g.getPassWord();
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(YoungsterPasswordView.this.getContext());
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordInput(passWord);
            int i = YoungsterPasswordView.this.k;
            if (i == 1) {
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(2);
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(YoungsterPasswordView.this.m);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
                YoungsterPasswordView.this.f14409g.e();
            } else if (i == 2) {
                if (StringUtils.isNull(YoungsterPasswordView.this.l)) {
                    return;
                }
                if (YoungsterPasswordView.this.l.equals(passWord)) {
                    c.f(passWord);
                    if (YoungsterPasswordView.this.m == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921487));
                        if (d.b.b.a.b.f().g() > 3) {
                            d.b.b.a.b.f().m(3);
                        }
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 2));
                        d.b.h0.r.a0.b.e(YoungsterPasswordView.this.getContext(), 2);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921509, Boolean.TRUE));
                    return;
                }
                if (YoungsterPasswordView.this.getParent() != null && !YoungsterPasswordView.this.n.isShown()) {
                    YoungsterPasswordView.this.n.j((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                }
                YoungsterPasswordView.this.f14409g.e();
            } else if (i == 3) {
                if (c.e(passWord)) {
                    c.a();
                    if (YoungsterPasswordView.this.m != 1) {
                        if (YoungsterPasswordView.this.m == 2 || YoungsterPasswordView.this.m == 3) {
                            d.b.h0.r.a0.b.e(YoungsterPasswordView.this.getContext(), 2);
                        }
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 3));
                        if (YoungsterPasswordView.this.f14407e != null) {
                            YoungsterPasswordView.this.f14407e.getPageActivity().finish();
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 3));
                    d.b.h0.r.d0.b.i().s("key_youngster_homgpage_top_view_closed", false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921509, Boolean.FALSE));
                    return;
                }
                if (YoungsterPasswordView.this.getParent() != null && !YoungsterPasswordView.this.n.isShown()) {
                    YoungsterPasswordView.this.n.j((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                }
                YoungsterPasswordView.this.f14409g.e();
            } else if (i != 4) {
                if (i == 5 && !StringUtils.isNull(YoungsterPasswordView.this.l)) {
                    if (YoungsterPasswordView.this.l.equals(passWord)) {
                        if (YoungsterPasswordView.this.m != 1) {
                            if (YoungsterPasswordView.this.m == 2 || YoungsterPasswordView.this.m == 3) {
                                c.f(passWord);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 5));
                                d.b.h0.r.a0.b.e(YoungsterPasswordView.this.getContext(), 2);
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 5));
                        if (d.b.b.a.b.f().g() > 3) {
                            d.b.b.a.b.f().m(3);
                            return;
                        }
                        return;
                    }
                    if (YoungsterPasswordView.this.getParent() != null && !YoungsterPasswordView.this.n.isShown()) {
                        YoungsterPasswordView.this.n.j((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                    }
                    YoungsterPasswordView.this.f14409g.e();
                }
            } else {
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(5);
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(YoungsterPasswordView.this.m);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
                YoungsterPasswordView.this.f14409g.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (YoungsterPasswordView.this.getParent() != null) {
                BdTopToast bdTopToast = new BdTopToast(YoungsterPasswordView.this.getContext(), 2000);
                bdTopToast.i(false);
                bdTopToast.h(YoungsterPasswordView.this.getContext().getString(R.string.youngster_settings_verify_fail));
                bdTopToast.j((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
            }
        }
    }

    public YoungsterPasswordView(TbPageContext<?> tbPageContext) {
        this(tbPageContext.getPageActivity());
        this.f14407e = tbPageContext;
        if (tbPageContext != null) {
            this.p.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.p);
        }
    }

    public void h() {
        this.f14409g.f();
    }

    public final void i() {
        LinearLayout.inflate(getContext(), R.layout.view_youngster_password, this);
        this.f14408f = (TextView) findViewById(R.id.txt_youngster_password_title);
        this.f14409g = (PasswordView) findViewById(R.id.password_view_youngster);
        this.f14410h = (TextView) findViewById(R.id.txt_youngster_password_content);
        this.i = (ImageView) findViewById(R.id.img_youngster_content_arrow);
        this.j = (LinearLayout) findViewById(R.id.youngster_content_group);
        this.f14409g.setOnPasswordInputComplete(this.o);
        this.j.setOnClickListener(this);
        BdTopToast bdTopToast = new BdTopToast(getContext(), 2000);
        bdTopToast.i(false);
        bdTopToast.h(getContext().getString(R.string.youngster_settings_input_password_error));
        this.n = bdTopToast;
    }

    public void j(int i) {
        this.k = i;
        this.i.setVisibility(8);
        if (i == 1) {
            this.f14408f.setText(R.string.youngster_settings_set_password);
            this.f14410h.setText(R.string.youngster_settings_set_password_content);
        } else if (i == 2) {
            this.f14408f.setText(R.string.youngster_settings_verify_password);
            this.f14410h.setText(R.string.youngster_settings_set_password_content);
        } else if (i == 3) {
            this.f14408f.setText(R.string.youngster_settings_input_password);
            this.f14410h.setText(R.string.youngster_settings_input_password_content);
            this.i.setVisibility(0);
        } else if (i == 4) {
            this.f14408f.setText(R.string.youngster_settings_set_new_password);
            this.f14410h.setText(R.string.youngster_settings_reset_password_content);
        } else if (i != 5) {
        } else {
            this.f14408f.setText(R.string.youngster_settings_verify_password);
            this.f14410h.setText(R.string.youngster_settings_reset_password_content);
        }
    }

    public void k() {
        SkinManager.setViewTextColor(this.f14408f, R.color.CAM_X0105);
        this.f14409g.j();
        SkinManager.setViewTextColor(this.f14410h, R.color.CAM_X0109);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void l() {
        this.f14409g.q();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.j && this.k == 3) {
            String youngsterVerifyUrl = YoungsterVerifyActivityConfig.getYoungsterVerifyUrl();
            if (!StringUtils.isNull(youngsterVerifyUrl)) {
                YoungsterVerifyActivityConfig youngsterVerifyActivityConfig = new YoungsterVerifyActivityConfig(getContext(), getContext().getString(R.string.youngster_settings_verify_title), youngsterVerifyUrl, true);
                youngsterVerifyActivityConfig.setKeyYoungsterPasswordFrom(this.m);
                youngsterVerifyActivityConfig.setNoMenu(true);
                youngsterVerifyActivityConfig.setFixTitle(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterVerifyActivityConfig));
            }
            this.f14409g.e();
        }
    }

    public void setFrom(int i) {
        this.m = i;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.f14407e = tbPageContext;
    }

    public void setPrePassword(String str) {
        this.l = str;
    }

    public YoungsterPasswordView(Context context) {
        this(context, null);
    }

    public YoungsterPasswordView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YoungsterPasswordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = new a();
        this.p = new b(2921489);
        i();
    }
}
