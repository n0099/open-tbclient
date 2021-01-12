package com.baidu.tieba.ala.liveroom.r;

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
/* loaded from: classes10.dex */
public class a extends Dialog implements View.OnClickListener {
    private String aBO;
    private TextView bUf;
    private boolean bkm;
    private View hIA;
    private View hIB;
    private PersonUserData hIC;
    private b hID;
    private int hIE;
    private TextView hIx;
    private TextView hIy;
    private TextView hIz;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0671a {
        void onConfirm();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void aM(String str, int i);

        void aN(String str, int i);

        void aO(String str, int i);

        void aP(String str, int i);

        void aQ(String str, int i);

        void aR(String str, int i);

        void onCancel();

        void vT(int i);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), a.i.theme_manage_dialog);
        this.hIE = 0;
        this.mPageContext = tbPageContext;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.ala_person_dialog_manage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.hIx = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hIA = findViewById(a.f.ala_person_forbid_this_divider);
        this.hIy = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hIB = findViewById(a.f.ala_person_forbid_this_divider);
        this.hIz = (TextView) findViewById(a.f.ala_person_admin);
        this.bUf = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hIx.setOnClickListener(this);
        this.hIy.setOnClickListener(this);
        this.hIz.setOnClickListener(this);
        this.bUf.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.hID != null) {
            if (view == this.hIx) {
                if (this.hIC != null && this.hIC.user_info != null) {
                    if (cje()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.r.a.1
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0671a
                            public void onConfirm() {
                                if (a.this.hIC != null && a.this.hIC.user_info != null) {
                                    a.this.hIC.user_info.is_block = 0;
                                    a.this.hID.aO(a.this.hIC.user_info.user_id, a.this.hIE);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hIC.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.r.a.2
                        @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0671a
                        public void onConfirm() {
                            if (a.this.hIC != null && a.this.hIC.user_info != null) {
                                a.this.hIC.user_info.is_block = 1;
                                a.this.hID.aM(a.this.hIC.user_info.user_id, a.this.hIE);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_this_confirm_tip), this.hIC.user_info.getNameShow()));
                }
            } else if (view == this.hIy) {
                if (this.hIC != null && this.hIC.user_info != null) {
                    if (cjd()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.r.a.3
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0671a
                            public void onConfirm() {
                                if (a.this.hIC != null && a.this.hIC.user_info != null) {
                                    a.this.hIC.user_info.is_block = 0;
                                    a.this.hID.aP(a.this.hIC.user_info.user_id, a.this.hIE);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hIC.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.r.a.4
                        @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0671a
                        public void onConfirm() {
                            if (a.this.hIC != null && a.this.hIC.user_info != null) {
                                a.this.hIC.user_info.is_block = 2;
                                a.this.hID.aN(a.this.hIC.user_info.user_id, a.this.hIE);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_forever_confirm_tip), this.hIC.user_info.getNameShow()));
                }
            } else if (view == this.hIz) {
                if (this.hIC != null && this.hIC.login_user_info != null) {
                    if (cjf()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.r.a.5
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0671a
                            public void onConfirm() {
                                if (a.this.hIC != null && a.this.hIC.login_user_info != null) {
                                    a.this.hIC.login_user_info.is_live_admin = 1;
                                    a.this.hID.aQ(a.this.hIC.user_info.user_id, a.this.hIE);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_appoint_admin_confirm_tip), this.hIC.user_info.getNameShow()));
                    } else if (cjg()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.r.a.6
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0671a
                            public void onConfirm() {
                                if (a.this.hIC != null && a.this.hIC.login_user_info != null) {
                                    a.this.hIC.login_user_info.is_live_admin = 0;
                                    a.this.hID.aR(a.this.hIC.user_info.user_id, a.this.hIE);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_fire_admin_confirm_tip), this.hIC.user_info.getNameShow()));
                    } else if (cjh()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0671a() { // from class: com.baidu.tieba.ala.liveroom.r.a.7
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0671a
                            public void onConfirm() {
                                if (a.this.hIC != null && a.this.hIC.login_user_info != null) {
                                    a.this.hIC.login_user_info.is_live_admin = 0;
                                    a.this.hID.vT(a.this.hIE);
                                }
                            }
                        }, getContext().getResources().getString(a.h.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.bUf) {
                this.hID.onCancel();
            }
        }
    }

    private void a(final InterfaceC0671a interfaceC0671a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.r.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0671a != null) {
                    interfaceC0671a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.r.a.9
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
        this.hIC = personUserData;
        this.bkm = z;
        this.aBO = str;
        if (this.hIC != null && this.hIC.user_info != null && this.hIC.user_info.extInfoJson != null) {
            if (this.hIC.user_info.extInfoJson.optInt("is_mysterious_man") == 1) {
                this.hIE = 1;
            }
        }
        if (cji() || cjj()) {
            vR(8);
            vS(8);
        } else if (cjd()) {
            vR(8);
            this.hIy.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (cje()) {
            vR(0);
            this.hIx.setText(a.h.ala_person_relieve_forbidden_this);
            this.hIy.setText(a.h.ala_person_forbid_forever);
        } else {
            vR(0);
            this.hIx.setText(a.h.ala_person_forbid_this);
            this.hIy.setText(a.h.ala_person_forbid_forever);
        }
        if (cjc()) {
            this.hIz.setVisibility(8);
            this.hIB.setVisibility(8);
        } else if (cjg()) {
            this.hIz.setText(a.h.ala_person_fire_admin);
        } else if (cjf()) {
            this.hIz.setText(a.h.ala_person_appoint_admin);
        } else if (cji() && cjh()) {
            this.hIz.setText(a.h.ala_person_resign_admin);
        } else {
            this.hIz.setVisibility(8);
            this.hIB.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.hID = bVar;
    }

    private boolean cjc() {
        return (this.hIC == null || this.hIC.user_info == null || this.hIC.user_info.is_block <= 0) ? false : true;
    }

    private boolean cjd() {
        return (this.hIC == null || this.hIC.user_info == null || this.hIC.user_info.is_block != 2) ? false : true;
    }

    private boolean cje() {
        return (this.hIC == null || this.hIC.user_info == null || this.hIC.user_info.is_block != 1) ? false : true;
    }

    private boolean cjf() {
        return this.hIC != null && this.hIC.user_info != null && this.bkm && this.hIC.user_info.is_live_admin == 0;
    }

    private boolean cjg() {
        return this.hIC != null && this.hIC.user_info != null && this.bkm && this.hIC.user_info.is_live_admin == 1;
    }

    private boolean cjh() {
        return (this.hIC == null || this.hIC.login_user_info == null || this.bkm || this.hIC.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean cji() {
        return (this.hIC == null || this.hIC.user_info == null || TextUtils.isEmpty(this.aBO) || !this.aBO.equals(this.hIC.user_info.user_id)) ? false : true;
    }

    private boolean cjj() {
        return (this.hIC == null || this.hIC.user_info == null || this.hIC.user_info.is_live_admin != 1) ? false : true;
    }

    private void vR(int i) {
        this.hIx.setVisibility(i);
        this.hIA.setVisibility(i);
    }

    private void vS(int i) {
        this.hIy.setVisibility(i);
        this.hIB.setVisibility(i);
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
