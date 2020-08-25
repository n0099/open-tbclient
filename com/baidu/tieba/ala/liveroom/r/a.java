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
/* loaded from: classes7.dex */
public class a extends Dialog implements View.OnClickListener {
    private String aAE;
    private boolean bbH;
    private TextView dCB;
    private TextView gHA;
    private TextView gHB;
    private TextView gHC;
    private View gHD;
    private View gHE;
    private PersonUserData gHF;
    private b gHG;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0638a {
        void onConfirm();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void Go(String str);

        void Gp(String str);

        void Gq(String str);

        void Gr(String str);

        void Gs(String str);

        void Gt(String str);

        void bWg();

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
        this.gHA = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.gHD = findViewById(a.g.ala_person_forbid_this_divider);
        this.gHB = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.gHE = findViewById(a.g.ala_person_forbid_this_divider);
        this.gHC = (TextView) findViewById(a.g.ala_person_admin);
        this.dCB = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.gHA.setOnClickListener(this);
        this.gHB.setOnClickListener(this);
        this.gHC.setOnClickListener(this);
        this.dCB.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.gHG != null) {
            if (view == this.gHA) {
                if (this.gHF != null && this.gHF.user_info != null) {
                    if (bWa()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0638a() { // from class: com.baidu.tieba.ala.liveroom.r.a.1
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0638a
                            public void onConfirm() {
                                if (a.this.gHF != null && a.this.gHF.user_info != null) {
                                    a.this.gHF.user_info.is_block = 0;
                                    a.this.gHG.Gq(a.this.gHF.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.gHF.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0638a() { // from class: com.baidu.tieba.ala.liveroom.r.a.2
                        @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0638a
                        public void onConfirm() {
                            if (a.this.gHF != null && a.this.gHF.user_info != null) {
                                a.this.gHF.user_info.is_block = 1;
                                a.this.gHG.Go(a.this.gHF.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.gHF.user_info.getNameShow()));
                }
            } else if (view == this.gHB) {
                if (this.gHF != null && this.gHF.user_info != null) {
                    if (bVZ()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0638a() { // from class: com.baidu.tieba.ala.liveroom.r.a.3
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0638a
                            public void onConfirm() {
                                if (a.this.gHF != null && a.this.gHF.user_info != null) {
                                    a.this.gHF.user_info.is_block = 0;
                                    a.this.gHG.Gr(a.this.gHF.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.gHF.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0638a() { // from class: com.baidu.tieba.ala.liveroom.r.a.4
                        @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0638a
                        public void onConfirm() {
                            if (a.this.gHF != null && a.this.gHF.user_info != null) {
                                a.this.gHF.user_info.is_block = 2;
                                a.this.gHG.Gp(a.this.gHF.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.gHF.user_info.getNameShow()));
                }
            } else if (view == this.gHC) {
                if (this.gHF != null && this.gHF.login_user_info != null) {
                    if (bWb()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0638a() { // from class: com.baidu.tieba.ala.liveroom.r.a.5
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0638a
                            public void onConfirm() {
                                if (a.this.gHF != null && a.this.gHF.login_user_info != null) {
                                    a.this.gHF.login_user_info.is_live_admin = 1;
                                    a.this.gHG.Gs(a.this.gHF.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.gHF.user_info.getNameShow()));
                    } else if (bWc()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0638a() { // from class: com.baidu.tieba.ala.liveroom.r.a.6
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0638a
                            public void onConfirm() {
                                if (a.this.gHF != null && a.this.gHF.login_user_info != null) {
                                    a.this.gHF.login_user_info.is_live_admin = 0;
                                    a.this.gHG.Gt(a.this.gHF.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.gHF.user_info.getNameShow()));
                    } else if (bWd()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0638a() { // from class: com.baidu.tieba.ala.liveroom.r.a.7
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0638a
                            public void onConfirm() {
                                if (a.this.gHF != null && a.this.gHF.login_user_info != null) {
                                    a.this.gHF.login_user_info.is_live_admin = 0;
                                    a.this.gHG.bWg();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.dCB) {
                this.gHG.onCancel();
            }
        }
    }

    private void a(final InterfaceC0638a interfaceC0638a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.r.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0638a != null) {
                    interfaceC0638a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.r.a.9
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
        this.gHF = personUserData;
        this.bbH = z;
        this.aAE = str;
        if (bWe() || bWf()) {
            uD(8);
            uE(8);
        } else if (bVZ()) {
            uD(8);
            this.gHB.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (bWa()) {
            uD(0);
            this.gHA.setText(a.i.ala_person_relieve_forbidden_this);
            this.gHB.setText(a.i.ala_person_forbid_forever);
        } else {
            uD(0);
            this.gHA.setText(a.i.ala_person_forbid_this);
            this.gHB.setText(a.i.ala_person_forbid_forever);
        }
        if (bVY()) {
            this.gHC.setVisibility(8);
            this.gHE.setVisibility(8);
        } else if (bWc()) {
            this.gHC.setText(a.i.ala_person_fire_admin);
        } else if (bWb()) {
            this.gHC.setText(a.i.ala_person_appoint_admin);
        } else if (bWe() && bWd()) {
            this.gHC.setText(a.i.ala_person_resign_admin);
        } else {
            this.gHC.setVisibility(8);
            this.gHE.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.gHG = bVar;
    }

    private boolean bVY() {
        return (this.gHF == null || this.gHF.user_info == null || this.gHF.user_info.is_block <= 0) ? false : true;
    }

    private boolean bVZ() {
        return (this.gHF == null || this.gHF.user_info == null || this.gHF.user_info.is_block != 2) ? false : true;
    }

    private boolean bWa() {
        return (this.gHF == null || this.gHF.user_info == null || this.gHF.user_info.is_block != 1) ? false : true;
    }

    private boolean bWb() {
        return this.gHF != null && this.gHF.user_info != null && this.bbH && this.gHF.user_info.is_live_admin == 0;
    }

    private boolean bWc() {
        return this.gHF != null && this.gHF.user_info != null && this.bbH && this.gHF.user_info.is_live_admin == 1;
    }

    private boolean bWd() {
        return (this.gHF == null || this.gHF.login_user_info == null || this.bbH || this.gHF.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean bWe() {
        return (this.gHF == null || this.gHF.user_info == null || TextUtils.isEmpty(this.aAE) || !this.aAE.equals(this.gHF.user_info.user_id)) ? false : true;
    }

    private boolean bWf() {
        return (this.gHF == null || this.gHF.user_info == null || this.gHF.user_info.is_live_admin != 1) ? false : true;
    }

    private void uD(int i) {
        this.gHA.setVisibility(i);
        this.gHD.setVisibility(i);
    }

    private void uE(int i) {
        this.gHB.setVisibility(i);
        this.gHE.setVisibility(i);
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
