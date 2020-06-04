package com.baidu.tieba.ala.liveroom.o;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a extends Dialog implements View.OnClickListener {
    private boolean aSw;
    private String aSx;
    private TextView dhT;
    private TextView gcH;
    private TextView gcI;
    private TextView gcJ;
    private View gcK;
    private View gcL;
    private PersonUserData gcM;
    private b gcN;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0567a {
        void onConfirm();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void CC(String str);

        void CD(String str);

        void CE(String str);

        void CF(String str);

        void CG(String str);

        void CH(String str);

        void bFT();

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
        this.gcH = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.gcK = findViewById(a.g.ala_person_forbid_this_divider);
        this.gcI = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.gcL = findViewById(a.g.ala_person_forbid_this_divider);
        this.gcJ = (TextView) findViewById(a.g.ala_person_admin);
        this.dhT = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.gcH.setOnClickListener(this);
        this.gcI.setOnClickListener(this);
        this.gcJ.setOnClickListener(this);
        this.dhT.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.gcN != null) {
            if (view == this.gcH) {
                if (this.gcM != null && this.gcM.user_info != null) {
                    if (bFN()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0567a() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0567a
                            public void onConfirm() {
                                if (a.this.gcM != null && a.this.gcM.user_info != null) {
                                    a.this.gcM.user_info.is_block = 0;
                                    a.this.gcN.CE(a.this.gcM.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.gcM.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0567a() { // from class: com.baidu.tieba.ala.liveroom.o.a.2
                        @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0567a
                        public void onConfirm() {
                            if (a.this.gcM != null && a.this.gcM.user_info != null) {
                                a.this.gcM.user_info.is_block = 1;
                                a.this.gcN.CC(a.this.gcM.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.gcM.user_info.getNameShow()));
                }
            } else if (view == this.gcI) {
                if (this.gcM != null && this.gcM.user_info != null) {
                    if (bFM()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0567a() { // from class: com.baidu.tieba.ala.liveroom.o.a.3
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0567a
                            public void onConfirm() {
                                if (a.this.gcM != null && a.this.gcM.user_info != null) {
                                    a.this.gcM.user_info.is_block = 0;
                                    a.this.gcN.CF(a.this.gcM.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.gcM.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0567a() { // from class: com.baidu.tieba.ala.liveroom.o.a.4
                        @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0567a
                        public void onConfirm() {
                            if (a.this.gcM != null && a.this.gcM.user_info != null) {
                                a.this.gcM.user_info.is_block = 2;
                                a.this.gcN.CD(a.this.gcM.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.gcM.user_info.getNameShow()));
                }
            } else if (view == this.gcJ) {
                if (this.gcM != null && this.gcM.login_user_info != null) {
                    if (bFO()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0567a() { // from class: com.baidu.tieba.ala.liveroom.o.a.5
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0567a
                            public void onConfirm() {
                                if (a.this.gcM != null && a.this.gcM.login_user_info != null) {
                                    a.this.gcM.login_user_info.is_live_admin = 1;
                                    a.this.gcN.CG(a.this.gcM.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.gcM.user_info.getNameShow()));
                    } else if (bFP()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0567a() { // from class: com.baidu.tieba.ala.liveroom.o.a.6
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0567a
                            public void onConfirm() {
                                if (a.this.gcM != null && a.this.gcM.login_user_info != null) {
                                    a.this.gcM.login_user_info.is_live_admin = 0;
                                    a.this.gcN.CH(a.this.gcM.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.gcM.user_info.getNameShow()));
                    } else if (bFQ()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0567a() { // from class: com.baidu.tieba.ala.liveroom.o.a.7
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0567a
                            public void onConfirm() {
                                if (a.this.gcM != null && a.this.gcM.login_user_info != null) {
                                    a.this.gcM.login_user_info.is_live_admin = 0;
                                    a.this.gcN.bFT();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.dhT) {
                this.gcN.onCancel();
            }
        }
    }

    private void a(final InterfaceC0567a interfaceC0567a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0567a != null) {
                    interfaceC0567a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.9
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
        this.gcM = personUserData;
        this.aSw = z;
        this.aSx = str;
        if (bFR() || bFS()) {
            ry(8);
            rz(8);
        } else if (bFM()) {
            ry(8);
            this.gcI.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (bFN()) {
            ry(0);
            this.gcH.setText(a.i.ala_person_relieve_forbidden_this);
            this.gcI.setText(a.i.ala_person_forbid_forever);
        } else {
            ry(0);
            this.gcH.setText(a.i.ala_person_forbid_this);
            this.gcI.setText(a.i.ala_person_forbid_forever);
        }
        if (bFL()) {
            this.gcJ.setVisibility(8);
            this.gcL.setVisibility(8);
        } else if (bFP()) {
            this.gcJ.setText(a.i.ala_person_fire_admin);
        } else if (bFO()) {
            this.gcJ.setText(a.i.ala_person_appoint_admin);
        } else if (bFR() && bFQ()) {
            this.gcJ.setText(a.i.ala_person_resign_admin);
        } else {
            this.gcJ.setVisibility(8);
            this.gcL.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.gcN = bVar;
    }

    private boolean bFL() {
        return (this.gcM == null || this.gcM.user_info == null || this.gcM.user_info.is_block <= 0) ? false : true;
    }

    private boolean bFM() {
        return (this.gcM == null || this.gcM.user_info == null || this.gcM.user_info.is_block != 2) ? false : true;
    }

    private boolean bFN() {
        return (this.gcM == null || this.gcM.user_info == null || this.gcM.user_info.is_block != 1) ? false : true;
    }

    private boolean bFO() {
        return this.gcM != null && this.gcM.user_info != null && this.aSw && this.gcM.user_info.is_live_admin == 0;
    }

    private boolean bFP() {
        return this.gcM != null && this.gcM.user_info != null && this.aSw && this.gcM.user_info.is_live_admin == 1;
    }

    private boolean bFQ() {
        return (this.gcM == null || this.gcM.login_user_info == null || this.aSw || this.gcM.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean bFR() {
        return (this.gcM == null || this.gcM.user_info == null || TextUtils.isEmpty(this.aSx) || !this.aSx.equals(this.gcM.user_info.user_id)) ? false : true;
    }

    private boolean bFS() {
        return (this.gcM == null || this.gcM.user_info == null || this.gcM.user_info.is_live_admin != 1) ? false : true;
    }

    private void ry(int i) {
        this.gcH.setVisibility(i);
        this.gcK.setVisibility(i);
    }

    private void rz(int i) {
        this.gcI.setVisibility(i);
        this.gcL.setVisibility(i);
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
