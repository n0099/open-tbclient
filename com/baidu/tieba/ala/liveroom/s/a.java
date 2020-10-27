package com.baidu.tieba.ala.liveroom.s;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a extends Dialog implements View.OnClickListener {
    private String aEz;
    private TextView bKf;
    private boolean bjr;
    private TextView hlS;
    private TextView hlT;
    private TextView hlU;
    private View hlV;
    private View hlW;
    private PersonUserData hlX;
    private b hlY;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0669a {
        void onConfirm();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void HZ(String str);

        void Ia(String str);

        void Ib(String str);

        void Ic(String str);

        void Id(String str);

        void Ie(String str);

        void cev();

        void onCancel();
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), a.j.theme_manage_dialog);
        this.mPageContext = tbPageContext;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.ala_person_dialog_manage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.hlS = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.hlV = findViewById(a.g.ala_person_forbid_this_divider);
        this.hlT = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.hlW = findViewById(a.g.ala_person_forbid_this_divider);
        this.hlU = (TextView) findViewById(a.g.ala_person_admin);
        this.bKf = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.hlS.setOnClickListener(this);
        this.hlT.setOnClickListener(this);
        this.hlU.setOnClickListener(this);
        this.bKf.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.hlY != null) {
            if (view == this.hlS) {
                if (this.hlX != null && this.hlX.user_info != null) {
                    if (cep()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0669a() { // from class: com.baidu.tieba.ala.liveroom.s.a.1
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0669a
                            public void onConfirm() {
                                if (a.this.hlX != null && a.this.hlX.user_info != null) {
                                    a.this.hlX.user_info.is_block = 0;
                                    a.this.hlY.Ib(a.this.hlX.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.hlX.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0669a() { // from class: com.baidu.tieba.ala.liveroom.s.a.2
                        @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0669a
                        public void onConfirm() {
                            if (a.this.hlX != null && a.this.hlX.user_info != null) {
                                a.this.hlX.user_info.is_block = 1;
                                a.this.hlY.HZ(a.this.hlX.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.hlX.user_info.getNameShow()));
                }
            } else if (view == this.hlT) {
                if (this.hlX != null && this.hlX.user_info != null) {
                    if (ceo()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0669a() { // from class: com.baidu.tieba.ala.liveroom.s.a.3
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0669a
                            public void onConfirm() {
                                if (a.this.hlX != null && a.this.hlX.user_info != null) {
                                    a.this.hlX.user_info.is_block = 0;
                                    a.this.hlY.Ic(a.this.hlX.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.hlX.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0669a() { // from class: com.baidu.tieba.ala.liveroom.s.a.4
                        @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0669a
                        public void onConfirm() {
                            if (a.this.hlX != null && a.this.hlX.user_info != null) {
                                a.this.hlX.user_info.is_block = 2;
                                a.this.hlY.Ia(a.this.hlX.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.hlX.user_info.getNameShow()));
                }
            } else if (view == this.hlU) {
                if (this.hlX != null && this.hlX.login_user_info != null) {
                    if (ceq()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0669a() { // from class: com.baidu.tieba.ala.liveroom.s.a.5
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0669a
                            public void onConfirm() {
                                if (a.this.hlX != null && a.this.hlX.login_user_info != null) {
                                    a.this.hlX.login_user_info.is_live_admin = 1;
                                    a.this.hlY.Id(a.this.hlX.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.hlX.user_info.getNameShow()));
                    } else if (cer()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0669a() { // from class: com.baidu.tieba.ala.liveroom.s.a.6
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0669a
                            public void onConfirm() {
                                if (a.this.hlX != null && a.this.hlX.login_user_info != null) {
                                    a.this.hlX.login_user_info.is_live_admin = 0;
                                    a.this.hlY.Ie(a.this.hlX.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.hlX.user_info.getNameShow()));
                    } else if (ces()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0669a() { // from class: com.baidu.tieba.ala.liveroom.s.a.7
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0669a
                            public void onConfirm() {
                                if (a.this.hlX != null && a.this.hlX.login_user_info != null) {
                                    a.this.hlX.login_user_info.is_live_admin = 0;
                                    a.this.hlY.cev();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.bKf) {
                this.hlY.onCancel();
            }
        }
    }

    private void a(final InterfaceC0669a interfaceC0669a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0669a != null) {
                    interfaceC0669a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.a.9
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(this.mPageContext).show();
    }

    public void a(PersonUserData personUserData, boolean z, String str) {
        super.show();
        if (personUserData != null) {
            b(personUserData, z, str);
        }
    }

    public void b(PersonUserData personUserData, boolean z, String str) {
        this.hlX = personUserData;
        this.bjr = z;
        this.aEz = str;
        if (cet() || ceu()) {
            vW(8);
            vX(8);
        } else if (ceo()) {
            vW(8);
            this.hlT.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (cep()) {
            vW(0);
            this.hlS.setText(a.i.ala_person_relieve_forbidden_this);
            this.hlT.setText(a.i.ala_person_forbid_forever);
        } else {
            vW(0);
            this.hlS.setText(a.i.ala_person_forbid_this);
            this.hlT.setText(a.i.ala_person_forbid_forever);
        }
        if (cen()) {
            this.hlU.setVisibility(8);
            this.hlW.setVisibility(8);
        } else if (cer()) {
            this.hlU.setText(a.i.ala_person_fire_admin);
        } else if (ceq()) {
            this.hlU.setText(a.i.ala_person_appoint_admin);
        } else if (cet() && ces()) {
            this.hlU.setText(a.i.ala_person_resign_admin);
        } else {
            this.hlU.setVisibility(8);
            this.hlW.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.hlY = bVar;
    }

    private boolean cen() {
        return (this.hlX == null || this.hlX.user_info == null || this.hlX.user_info.is_block <= 0) ? false : true;
    }

    private boolean ceo() {
        return (this.hlX == null || this.hlX.user_info == null || this.hlX.user_info.is_block != 2) ? false : true;
    }

    private boolean cep() {
        return (this.hlX == null || this.hlX.user_info == null || this.hlX.user_info.is_block != 1) ? false : true;
    }

    private boolean ceq() {
        return this.hlX != null && this.hlX.user_info != null && this.bjr && this.hlX.user_info.is_live_admin == 0;
    }

    private boolean cer() {
        return this.hlX != null && this.hlX.user_info != null && this.bjr && this.hlX.user_info.is_live_admin == 1;
    }

    private boolean ces() {
        return (this.hlX == null || this.hlX.login_user_info == null || this.bjr || this.hlX.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean cet() {
        return (this.hlX == null || this.hlX.user_info == null || TextUtils.isEmpty(this.aEz) || !this.aEz.equals(this.hlX.user_info.user_id)) ? false : true;
    }

    private boolean ceu() {
        return (this.hlX == null || this.hlX.user_info == null || this.hlX.user_info.is_live_admin != 1) ? false : true;
    }

    private void vW(int i) {
        this.hlS.setVisibility(i);
        this.hlV.setVisibility(i);
    }

    private void vX(int i) {
        this.hlT.setVisibility(i);
        this.hlW.setVisibility(i);
    }

    public void resize() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mPageContext.getPageActivity());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
            attributes.width = Math.max(screenDimensions[0], screenDimensions[1]);
        } else {
            attributes.width = Math.min(screenDimensions[0], screenDimensions[1]);
        }
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
