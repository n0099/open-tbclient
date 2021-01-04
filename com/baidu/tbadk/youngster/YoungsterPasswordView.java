package com.baidu.tbadk.youngster;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.b;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.youngster.PasswordView;
import com.baidu.tbadk.youngster.b.c;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
/* loaded from: classes.dex */
public class YoungsterPasswordView extends LinearLayout implements View.OnClickListener {
    private int from;
    private PasswordView.a gdK;
    private TextView gdT;
    private PasswordView gdU;
    private TextView gdV;
    private ImageView gdW;
    private LinearLayout gdX;
    private String gdY;
    private BdTopToast gdZ;
    private CustomMessageListener gea;
    private TbPageContext<?> pageContext;
    private int pageType;

    public YoungsterPasswordView(TbPageContext<?> tbPageContext) {
        this(tbPageContext.getPageActivity());
        this.pageContext = tbPageContext;
        if (tbPageContext != null) {
            this.gea.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.gea);
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
        this.gdK = new PasswordView.a() { // from class: com.baidu.tbadk.youngster.YoungsterPasswordView.1
            @Override // com.baidu.tbadk.youngster.PasswordView.a
            public void onComplete() {
                String passWord = YoungsterPasswordView.this.gdU.getPassWord();
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(YoungsterPasswordView.this.getContext());
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordInput(passWord);
                switch (YoungsterPasswordView.this.pageType) {
                    case 1:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(2);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(YoungsterPasswordView.this.from);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
                        YoungsterPasswordView.this.gdU.bMs();
                        return;
                    case 2:
                        if (!StringUtils.isNull(YoungsterPasswordView.this.gdY)) {
                            if (YoungsterPasswordView.this.gdY.equals(passWord)) {
                                c.Fa(passWord);
                                if (YoungsterPasswordView.this.from == 1) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921487));
                                    if (b.kC().getSize() > 3) {
                                        b.kC().ab(3);
                                    }
                                } else {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 2));
                                    com.baidu.tbadk.core.e.b.B(YoungsterPasswordView.this.getContext(), 2);
                                }
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921509, true));
                                return;
                            }
                            if (YoungsterPasswordView.this.getParent() != null && !YoungsterPasswordView.this.gdZ.isShown()) {
                                YoungsterPasswordView.this.gdZ.aR((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                            }
                            YoungsterPasswordView.this.gdU.bMs();
                            return;
                        }
                        return;
                    case 3:
                        if (c.Fb(passWord)) {
                            c.bMC();
                            if (YoungsterPasswordView.this.from != 1) {
                                if (YoungsterPasswordView.this.from == 2 || YoungsterPasswordView.this.from == 3) {
                                    com.baidu.tbadk.core.e.b.B(YoungsterPasswordView.this.getContext(), 2);
                                }
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 3));
                                if (YoungsterPasswordView.this.pageContext != null) {
                                    YoungsterPasswordView.this.pageContext.getPageActivity().finish();
                                }
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 3));
                            com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("key_youngster_homgpage_top_view_closed", false);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921509, false));
                            return;
                        }
                        if (YoungsterPasswordView.this.getParent() != null && !YoungsterPasswordView.this.gdZ.isShown()) {
                            YoungsterPasswordView.this.gdZ.aR((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                        }
                        YoungsterPasswordView.this.gdU.bMs();
                        return;
                    case 4:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(5);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(YoungsterPasswordView.this.from);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
                        YoungsterPasswordView.this.gdU.bMs();
                        return;
                    case 5:
                        if (!StringUtils.isNull(YoungsterPasswordView.this.gdY)) {
                            if (YoungsterPasswordView.this.gdY.equals(passWord)) {
                                if (YoungsterPasswordView.this.from != 1) {
                                    if (YoungsterPasswordView.this.from == 2 || YoungsterPasswordView.this.from == 3) {
                                        c.Fa(passWord);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 5));
                                        com.baidu.tbadk.core.e.b.B(YoungsterPasswordView.this.getContext(), 2);
                                        return;
                                    }
                                    return;
                                }
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 5));
                                if (b.kC().getSize() > 3) {
                                    b.kC().ab(3);
                                    return;
                                }
                                return;
                            }
                            if (YoungsterPasswordView.this.getParent() != null && !YoungsterPasswordView.this.gdZ.isShown()) {
                                YoungsterPasswordView.this.gdZ.aR((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                            }
                            YoungsterPasswordView.this.gdU.bMs();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gea = new CustomMessageListener(2921489) { // from class: com.baidu.tbadk.youngster.YoungsterPasswordView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (YoungsterPasswordView.this.getParent() != null) {
                    new BdTopToast(YoungsterPasswordView.this.getContext(), 2000).yW(false).UY(YoungsterPasswordView.this.getContext().getString(R.string.youngster_settings_verify_fail)).aR((ViewGroup) YoungsterPasswordView.this.getParent().getParent());
                }
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_youngster_password, this);
        this.gdT = (TextView) findViewById(R.id.txt_youngster_password_title);
        this.gdU = (PasswordView) findViewById(R.id.password_view_youngster);
        this.gdV = (TextView) findViewById(R.id.txt_youngster_password_content);
        this.gdW = (ImageView) findViewById(R.id.img_youngster_content_arrow);
        this.gdX = (LinearLayout) findViewById(R.id.youngster_content_group);
        this.gdU.setOnPasswordInputComplete(this.gdK);
        this.gdX.setOnClickListener(this);
        this.gdZ = new BdTopToast(getContext(), 2000).yW(false).UY(getContext().getString(R.string.youngster_settings_input_password_error));
    }

    public void ul(int i) {
        this.pageType = i;
        this.gdW.setVisibility(8);
        switch (i) {
            case 1:
                this.gdT.setText(R.string.youngster_settings_set_password);
                this.gdV.setText(R.string.youngster_settings_set_password_content);
                return;
            case 2:
                this.gdT.setText(R.string.youngster_settings_verify_password);
                this.gdV.setText(R.string.youngster_settings_set_password_content);
                return;
            case 3:
                this.gdT.setText(R.string.youngster_settings_input_password);
                this.gdV.setText(R.string.youngster_settings_input_password_content);
                this.gdW.setVisibility(0);
                return;
            case 4:
                this.gdT.setText(R.string.youngster_settings_set_new_password);
                this.gdV.setText(R.string.youngster_settings_reset_password_content);
                return;
            case 5:
                this.gdT.setText(R.string.youngster_settings_verify_password);
                this.gdV.setText(R.string.youngster_settings_reset_password_content);
                return;
            default:
                return;
        }
    }

    public void bMt() {
        this.gdU.bMt();
    }

    public void bMu() {
        this.gdU.bMu();
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.pageContext = tbPageContext;
    }

    public void setPrePassword(String str) {
        this.gdY = str;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.gdT, R.color.CAM_X0105);
        this.gdU.onChangeSkinType();
        ao.setViewTextColor(this.gdV, R.color.CAM_X0109);
        SvgManager.bwq().a(this.gdW, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gdX && this.pageType == 3) {
            String youngsterVerifyUrl = YoungsterVerifyActivityConfig.getYoungsterVerifyUrl();
            if (!StringUtils.isNull(youngsterVerifyUrl)) {
                YoungsterVerifyActivityConfig youngsterVerifyActivityConfig = new YoungsterVerifyActivityConfig(getContext(), getContext().getString(R.string.youngster_settings_verify_title), youngsterVerifyUrl, true);
                youngsterVerifyActivityConfig.setKeyYoungsterPasswordFrom(this.from);
                youngsterVerifyActivityConfig.setNoMenu(true);
                youngsterVerifyActivityConfig.setFixTitle(true);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterVerifyActivityConfig));
            }
            this.gdU.bMs();
        }
    }
}
