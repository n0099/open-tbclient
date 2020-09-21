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
    private TextView fmD;
    private PasswordView fmE;
    private TextView fmF;
    private ImageView fmG;
    private LinearLayout fmH;
    private String fmI;
    private BdTopToast fmJ;
    private CustomMessageListener fmK;
    private PasswordView.a fmu;
    private int from;
    private TbPageContext<?> pageContext;
    private int pageType;

    public YoungsterPasswordView(TbPageContext<?> tbPageContext) {
        this(tbPageContext.getPageActivity());
        this.pageContext = tbPageContext;
        if (tbPageContext != null) {
            this.fmK.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.fmK);
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
        this.fmu = new PasswordView.a() { // from class: com.baidu.tbadk.youngster.YoungsterPasswordView.1
            @Override // com.baidu.tbadk.youngster.PasswordView.a
            public void onComplete() {
                String passWord = YoungsterPasswordView.this.fmE.getPassWord();
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(YoungsterPasswordView.this.getContext());
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordInput(passWord);
                switch (YoungsterPasswordView.this.pageType) {
                    case 1:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(2);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(YoungsterPasswordView.this.from);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
                        YoungsterPasswordView.this.fmE.bAf();
                        return;
                    case 2:
                        if (!StringUtils.isNull(YoungsterPasswordView.this.fmI)) {
                            if (YoungsterPasswordView.this.fmI.equals(passWord)) {
                                b.Dv(passWord);
                                if (YoungsterPasswordView.this.from == 1) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921487));
                                    if (a.lf().getSize() > 3) {
                                        a.lf().Y(3);
                                        return;
                                    }
                                    return;
                                }
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 2));
                                com.baidu.tbadk.core.e.b.r(YoungsterPasswordView.this.getContext(), 2);
                                return;
                            }
                            if (YoungsterPasswordView.this.getParent() != null && !YoungsterPasswordView.this.fmJ.isShown()) {
                                YoungsterPasswordView.this.fmJ.aF((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                            }
                            YoungsterPasswordView.this.fmE.bAf();
                            return;
                        }
                        return;
                    case 3:
                        if (b.Dw(passWord)) {
                            b.bAn();
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
                            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_youngster_homgpage_top_view_closed", false);
                            return;
                        }
                        if (YoungsterPasswordView.this.getParent() != null && !YoungsterPasswordView.this.fmJ.isShown()) {
                            YoungsterPasswordView.this.fmJ.aF((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                        }
                        YoungsterPasswordView.this.fmE.bAf();
                        return;
                    case 4:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(5);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(YoungsterPasswordView.this.from);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
                        YoungsterPasswordView.this.fmE.bAf();
                        return;
                    case 5:
                        if (!StringUtils.isNull(YoungsterPasswordView.this.fmI)) {
                            if (YoungsterPasswordView.this.fmI.equals(passWord)) {
                                if (YoungsterPasswordView.this.from != 1) {
                                    if (YoungsterPasswordView.this.from == 2 || YoungsterPasswordView.this.from == 3) {
                                        b.Dv(passWord);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 5));
                                        com.baidu.tbadk.core.e.b.r(YoungsterPasswordView.this.getContext(), 2);
                                        return;
                                    }
                                    return;
                                }
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 5));
                                if (a.lf().getSize() > 3) {
                                    a.lf().Y(3);
                                    return;
                                }
                                return;
                            }
                            if (YoungsterPasswordView.this.getParent() != null && !YoungsterPasswordView.this.fmJ.isShown()) {
                                YoungsterPasswordView.this.fmJ.aF((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                            }
                            YoungsterPasswordView.this.fmE.bAf();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.fmK = new CustomMessageListener(2921489) { // from class: com.baidu.tbadk.youngster.YoungsterPasswordView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (YoungsterPasswordView.this.getParent() != null) {
                    new BdTopToast(YoungsterPasswordView.this.getContext(), 2000).xd(false).SP(YoungsterPasswordView.this.getContext().getString(R.string.youngster_settings_verify_fail)).aF((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_youngster_password, this);
        this.fmD = (TextView) findViewById(R.id.txt_youngster_password_title);
        this.fmE = (PasswordView) findViewById(R.id.password_view_youngster);
        this.fmF = (TextView) findViewById(R.id.txt_youngster_password_content);
        this.fmG = (ImageView) findViewById(R.id.img_youngster_content_arrow);
        this.fmH = (LinearLayout) findViewById(R.id.youngster_content_group);
        this.fmE.setOnPasswordInputComplete(this.fmu);
        this.fmH.setOnClickListener(this);
        this.fmJ = new BdTopToast(getContext(), 2000).xd(false).SP(getContext().getString(R.string.youngster_settings_input_password_error));
    }

    public void sf(int i) {
        this.pageType = i;
        this.fmG.setVisibility(8);
        switch (i) {
            case 1:
                this.fmD.setText(R.string.youngster_settings_set_password);
                this.fmF.setText(R.string.youngster_settings_set_password_content);
                return;
            case 2:
                this.fmD.setText(R.string.youngster_settings_verify_password);
                this.fmF.setText(R.string.youngster_settings_set_password_content);
                return;
            case 3:
                this.fmD.setText(R.string.youngster_settings_input_password);
                this.fmF.setText(R.string.youngster_settings_input_password_content);
                this.fmG.setVisibility(0);
                return;
            case 4:
                this.fmD.setText(R.string.youngster_settings_set_new_password);
                this.fmF.setText(R.string.youngster_settings_reset_password_content);
                return;
            case 5:
                this.fmD.setText(R.string.youngster_settings_verify_password);
                this.fmF.setText(R.string.youngster_settings_reset_password_content);
                return;
            default:
                return;
        }
    }

    public void bAg() {
        this.fmE.bAg();
    }

    public void bAh() {
        this.fmE.bAh();
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.pageContext = tbPageContext;
    }

    public void setPrePassword(String str) {
        this.fmI = str;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.fmD, R.color.cp_cont_b);
        this.fmE.onChangeSkinType();
        ap.setViewTextColor(this.fmF, R.color.cp_cont_d);
        SvgManager.bkl().a(this.fmG, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fmH && this.pageType == 3) {
            String youngsterVerifyUrl = YoungsterVerifyActivityConfig.getYoungsterVerifyUrl();
            if (!StringUtils.isNull(youngsterVerifyUrl)) {
                YoungsterVerifyActivityConfig youngsterVerifyActivityConfig = new YoungsterVerifyActivityConfig(getContext(), getContext().getString(R.string.youngster_settings_verify_title), youngsterVerifyUrl, true);
                youngsterVerifyActivityConfig.setKeyYoungsterPasswordFrom(this.from);
                youngsterVerifyActivityConfig.setNoMenu(true);
                youngsterVerifyActivityConfig.setFixTitle(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterVerifyActivityConfig));
            }
            this.fmE.bAf();
        }
    }
}
