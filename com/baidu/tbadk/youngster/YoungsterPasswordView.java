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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.youngster.PasswordView;
import com.baidu.tbadk.youngster.b.b;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
/* loaded from: classes.dex */
public class YoungsterPasswordView extends LinearLayout implements View.OnClickListener {
    private PasswordView.a fjB;
    private TextView fjK;
    private PasswordView fjL;
    private TextView fjM;
    private ImageView fjN;
    private LinearLayout fjO;
    private String fjP;
    private BdTopToast fjQ;
    private CustomMessageListener fjR;
    private int from;
    private TbPageContext<?> pageContext;
    private int pageType;

    public YoungsterPasswordView(TbPageContext<?> tbPageContext) {
        this(tbPageContext.getPageActivity());
        this.pageContext = tbPageContext;
        if (tbPageContext != null) {
            this.fjR.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.fjR);
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
        this.fjB = new PasswordView.a() { // from class: com.baidu.tbadk.youngster.YoungsterPasswordView.1
            @Override // com.baidu.tbadk.youngster.PasswordView.a
            public void onComplete() {
                String passWord = YoungsterPasswordView.this.fjL.getPassWord();
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(YoungsterPasswordView.this.getContext());
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordInput(passWord);
                switch (YoungsterPasswordView.this.pageType) {
                    case 1:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(2);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(YoungsterPasswordView.this.from);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
                        YoungsterPasswordView.this.fjL.byW();
                        return;
                    case 2:
                        if (!StringUtils.isNull(YoungsterPasswordView.this.fjP)) {
                            if (YoungsterPasswordView.this.fjP.equals(passWord)) {
                                b.CZ(passWord);
                                if (YoungsterPasswordView.this.from == 1) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921487));
                                    if (a.lb().getSize() > 3) {
                                        a.lb().X(3);
                                        return;
                                    }
                                    return;
                                }
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 2));
                                com.baidu.tbadk.core.e.b.r(YoungsterPasswordView.this.getContext(), 2);
                                return;
                            }
                            if (YoungsterPasswordView.this.getParent() != null && !YoungsterPasswordView.this.fjQ.isShown()) {
                                YoungsterPasswordView.this.fjQ.aE((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                            }
                            YoungsterPasswordView.this.fjL.byW();
                            return;
                        }
                        return;
                    case 3:
                        if (b.Da(passWord)) {
                            b.bze();
                            if (YoungsterPasswordView.this.from != 1) {
                                if (YoungsterPasswordView.this.from == 2 || YoungsterPasswordView.this.from == 3) {
                                    com.baidu.tbadk.core.e.b.r(YoungsterPasswordView.this.getContext(), 2);
                                }
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 3));
                                if (YoungsterPasswordView.this.pageContext != null) {
                                    YoungsterPasswordView.this.pageContext.getPageActivity().finish();
                                }
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 3));
                            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_youngster_homgpage_top_view_closed", false);
                            return;
                        }
                        if (YoungsterPasswordView.this.getParent() != null && !YoungsterPasswordView.this.fjQ.isShown()) {
                            YoungsterPasswordView.this.fjQ.aE((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                        }
                        YoungsterPasswordView.this.fjL.byW();
                        return;
                    case 4:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(5);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(YoungsterPasswordView.this.from);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
                        YoungsterPasswordView.this.fjL.byW();
                        return;
                    case 5:
                        if (!StringUtils.isNull(YoungsterPasswordView.this.fjP)) {
                            if (YoungsterPasswordView.this.fjP.equals(passWord)) {
                                if (YoungsterPasswordView.this.from != 1) {
                                    if (YoungsterPasswordView.this.from == 2 || YoungsterPasswordView.this.from == 3) {
                                        b.CZ(passWord);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 5));
                                        com.baidu.tbadk.core.e.b.r(YoungsterPasswordView.this.getContext(), 2);
                                        return;
                                    }
                                    return;
                                }
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 5));
                                if (a.lb().getSize() > 3) {
                                    a.lb().X(3);
                                    return;
                                }
                                return;
                            }
                            if (YoungsterPasswordView.this.getParent() != null && !YoungsterPasswordView.this.fjQ.isShown()) {
                                YoungsterPasswordView.this.fjQ.aE((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                            }
                            YoungsterPasswordView.this.fjL.byW();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fjR = new CustomMessageListener(2921489) { // from class: com.baidu.tbadk.youngster.YoungsterPasswordView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (YoungsterPasswordView.this.getParent() != null) {
                    new BdTopToast(YoungsterPasswordView.this.getContext(), 2000).wU(false).Sp(YoungsterPasswordView.this.getContext().getString(R.string.youngster_settings_verify_fail)).aE((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_youngster_password, this);
        this.fjK = (TextView) findViewById(R.id.txt_youngster_password_title);
        this.fjL = (PasswordView) findViewById(R.id.password_view_youngster);
        this.fjM = (TextView) findViewById(R.id.txt_youngster_password_content);
        this.fjN = (ImageView) findViewById(R.id.img_youngster_content_arrow);
        this.fjO = (LinearLayout) findViewById(R.id.youngster_content_group);
        this.fjL.setOnPasswordInputComplete(this.fjB);
        this.fjO.setOnClickListener(this);
        this.fjQ = new BdTopToast(getContext(), 2000).wU(false).Sp(getContext().getString(R.string.youngster_settings_input_password_error));
    }

    public void rO(int i) {
        this.pageType = i;
        this.fjN.setVisibility(8);
        switch (i) {
            case 1:
                this.fjK.setText(R.string.youngster_settings_set_password);
                this.fjM.setText(R.string.youngster_settings_set_password_content);
                return;
            case 2:
                this.fjK.setText(R.string.youngster_settings_verify_password);
                this.fjM.setText(R.string.youngster_settings_set_password_content);
                return;
            case 3:
                this.fjK.setText(R.string.youngster_settings_input_password);
                this.fjM.setText(R.string.youngster_settings_input_password_content);
                this.fjN.setVisibility(0);
                return;
            case 4:
                this.fjK.setText(R.string.youngster_settings_set_new_password);
                this.fjM.setText(R.string.youngster_settings_reset_password_content);
                return;
            case 5:
                this.fjK.setText(R.string.youngster_settings_verify_password);
                this.fjM.setText(R.string.youngster_settings_reset_password_content);
                return;
            default:
                return;
        }
    }

    public void byX() {
        this.fjL.byX();
    }

    public void byY() {
        this.fjL.byY();
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.pageContext = tbPageContext;
    }

    public void setPrePassword(String str) {
        this.fjP = str;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.fjK, R.color.cp_cont_b);
        this.fjL.onChangeSkinType();
        ap.setViewTextColor(this.fjM, R.color.cp_cont_d);
        SvgManager.bjq().a(this.fjN, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fjO && this.pageType == 3) {
            String youngsterVerifyUrl = YoungsterVerifyActivityConfig.getYoungsterVerifyUrl();
            if (!StringUtils.isNull(youngsterVerifyUrl)) {
                YoungsterVerifyActivityConfig youngsterVerifyActivityConfig = new YoungsterVerifyActivityConfig(getContext(), getContext().getString(R.string.youngster_settings_verify_title), youngsterVerifyUrl, true);
                youngsterVerifyActivityConfig.setKeyYoungsterPasswordFrom(this.from);
                youngsterVerifyActivityConfig.setNoMenu(true);
                youngsterVerifyActivityConfig.setFixTitle(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterVerifyActivityConfig));
            }
            this.fjL.byW();
        }
    }
}
