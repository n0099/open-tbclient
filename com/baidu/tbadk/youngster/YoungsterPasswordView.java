package com.baidu.tbadk.youngster;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterVerifyActivityConfig;
import com.baidu.tbadk.core.e.b;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.youngster.PasswordView;
import com.baidu.tbadk.youngster.b.c;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
/* loaded from: classes.dex */
public class YoungsterPasswordView extends LinearLayout implements View.OnClickListener {
    private PasswordView.a fUg;
    private TextView fUp;
    private PasswordView fUq;
    private TextView fUr;
    private ImageView fUs;
    private LinearLayout fUt;
    private String fUu;
    private BdTopToast fUv;
    private CustomMessageListener fUw;
    private int from;
    private TbPageContext<?> pageContext;
    private int pageType;

    public YoungsterPasswordView(TbPageContext<?> tbPageContext) {
        this(tbPageContext.getPageActivity());
        this.pageContext = tbPageContext;
        if (tbPageContext != null) {
            this.fUw.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.fUw);
        }
    }

    public YoungsterPasswordView(Context context) {
        this(context, null);
    }

    public YoungsterPasswordView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YoungsterPasswordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fUg = new PasswordView.a() { // from class: com.baidu.tbadk.youngster.YoungsterPasswordView.1
            @Override // com.baidu.tbadk.youngster.PasswordView.a
            public void onComplete() {
                String passWord = YoungsterPasswordView.this.fUq.getPassWord();
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(YoungsterPasswordView.this.getContext());
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordInput(passWord);
                switch (YoungsterPasswordView.this.pageType) {
                    case 1:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(2);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(YoungsterPasswordView.this.from);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
                        YoungsterPasswordView.this.fUq.bKa();
                        return;
                    case 2:
                        if (!StringUtils.isNull(YoungsterPasswordView.this.fUu)) {
                            if (YoungsterPasswordView.this.fUu.equals(passWord)) {
                                c.Fc(passWord);
                                if (YoungsterPasswordView.this.from == 1) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921487));
                                    if (a.lg().getSize() > 3) {
                                        a.lg().ab(3);
                                    }
                                } else {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 2));
                                    b.A(YoungsterPasswordView.this.getContext(), 2);
                                }
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921509, true));
                                return;
                            }
                            if (YoungsterPasswordView.this.getParent() != null && !YoungsterPasswordView.this.fUv.isShown()) {
                                YoungsterPasswordView.this.fUv.aF((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                            }
                            YoungsterPasswordView.this.fUq.bKa();
                            return;
                        }
                        return;
                    case 3:
                        if (c.Fd(passWord)) {
                            c.bKk();
                            if (YoungsterPasswordView.this.from != 1) {
                                if (YoungsterPasswordView.this.from == 2 || YoungsterPasswordView.this.from == 3) {
                                    b.A(YoungsterPasswordView.this.getContext(), 2);
                                }
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 3));
                                if (YoungsterPasswordView.this.pageContext != null) {
                                    YoungsterPasswordView.this.pageContext.getPageActivity().finish();
                                }
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 3));
                            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_youngster_homgpage_top_view_closed", false);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921509, false));
                            return;
                        }
                        if (YoungsterPasswordView.this.getParent() != null && !YoungsterPasswordView.this.fUv.isShown()) {
                            YoungsterPasswordView.this.fUv.aF((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                        }
                        YoungsterPasswordView.this.fUq.bKa();
                        return;
                    case 4:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(5);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(YoungsterPasswordView.this.from);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
                        YoungsterPasswordView.this.fUq.bKa();
                        return;
                    case 5:
                        if (!StringUtils.isNull(YoungsterPasswordView.this.fUu)) {
                            if (YoungsterPasswordView.this.fUu.equals(passWord)) {
                                if (YoungsterPasswordView.this.from != 1) {
                                    if (YoungsterPasswordView.this.from == 2 || YoungsterPasswordView.this.from == 3) {
                                        c.Fc(passWord);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 5));
                                        b.A(YoungsterPasswordView.this.getContext(), 2);
                                        return;
                                    }
                                    return;
                                }
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 5));
                                if (a.lg().getSize() > 3) {
                                    a.lg().ab(3);
                                    return;
                                }
                                return;
                            }
                            if (YoungsterPasswordView.this.getParent() != null && !YoungsterPasswordView.this.fUv.isShown()) {
                                YoungsterPasswordView.this.fUv.aF((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                            }
                            YoungsterPasswordView.this.fUq.bKa();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fUw = new CustomMessageListener(2921489) { // from class: com.baidu.tbadk.youngster.YoungsterPasswordView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (YoungsterPasswordView.this.getParent() != null) {
                    new BdTopToast(YoungsterPasswordView.this.getContext(), 2000).yW(false).Vt(YoungsterPasswordView.this.getContext().getString(R.string.youngster_settings_verify_fail)).aF((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_youngster_password, this);
        this.fUp = (TextView) findViewById(R.id.txt_youngster_password_title);
        this.fUq = (PasswordView) findViewById(R.id.password_view_youngster);
        this.fUr = (TextView) findViewById(R.id.txt_youngster_password_content);
        this.fUs = (ImageView) findViewById(R.id.img_youngster_content_arrow);
        this.fUt = (LinearLayout) findViewById(R.id.youngster_content_group);
        this.fUq.setOnPasswordInputComplete(this.fUg);
        this.fUt.setOnClickListener(this);
        this.fUv = new BdTopToast(getContext(), 2000).yW(false).Vt(getContext().getString(R.string.youngster_settings_input_password_error));
    }

    public void tZ(int i) {
        this.pageType = i;
        this.fUs.setVisibility(8);
        switch (i) {
            case 1:
                this.fUp.setText(R.string.youngster_settings_set_password);
                this.fUr.setText(R.string.youngster_settings_set_password_content);
                return;
            case 2:
                this.fUp.setText(R.string.youngster_settings_verify_password);
                this.fUr.setText(R.string.youngster_settings_set_password_content);
                return;
            case 3:
                this.fUp.setText(R.string.youngster_settings_input_password);
                this.fUr.setText(R.string.youngster_settings_input_password_content);
                this.fUs.setVisibility(0);
                return;
            case 4:
                this.fUp.setText(R.string.youngster_settings_set_new_password);
                this.fUr.setText(R.string.youngster_settings_reset_password_content);
                return;
            case 5:
                this.fUp.setText(R.string.youngster_settings_verify_password);
                this.fUr.setText(R.string.youngster_settings_reset_password_content);
                return;
            default:
                return;
        }
    }

    public void bKb() {
        this.fUq.bKb();
    }

    public void bKc() {
        this.fUq.bKc();
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.pageContext = tbPageContext;
    }

    public void setPrePassword(String str) {
        this.fUu = str;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.fUp, R.color.CAM_X0105);
        this.fUq.onChangeSkinType();
        ap.setViewTextColor(this.fUr, R.color.CAM_X0109);
        SvgManager.btW().a(this.fUs, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fUt && this.pageType == 3) {
            String youngsterVerifyUrl = YoungsterVerifyActivityConfig.getYoungsterVerifyUrl();
            if (!StringUtils.isNull(youngsterVerifyUrl)) {
                YoungsterVerifyActivityConfig youngsterVerifyActivityConfig = new YoungsterVerifyActivityConfig(getContext(), getContext().getString(R.string.youngster_settings_verify_title), youngsterVerifyUrl, true);
                youngsterVerifyActivityConfig.setKeyYoungsterPasswordFrom(this.from);
                youngsterVerifyActivityConfig.setNoMenu(true);
                youngsterVerifyActivityConfig.setFixTitle(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterVerifyActivityConfig));
            }
            this.fUq.bKa();
        }
    }
}
