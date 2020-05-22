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
    private View gcA;
    private PersonUserData gcB;
    private b gcC;
    private TextView gcw;
    private TextView gcx;
    private TextView gcy;
    private View gcz;
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

        void bFR();

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
        this.gcw = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.gcz = findViewById(a.g.ala_person_forbid_this_divider);
        this.gcx = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.gcA = findViewById(a.g.ala_person_forbid_this_divider);
        this.gcy = (TextView) findViewById(a.g.ala_person_admin);
        this.dhT = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.gcw.setOnClickListener(this);
        this.gcx.setOnClickListener(this);
        this.gcy.setOnClickListener(this);
        this.dhT.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.gcC != null) {
            if (view == this.gcw) {
                if (this.gcB != null && this.gcB.user_info != null) {
                    if (bFL()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0567a() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0567a
                            public void onConfirm() {
                                if (a.this.gcB != null && a.this.gcB.user_info != null) {
                                    a.this.gcB.user_info.is_block = 0;
                                    a.this.gcC.CE(a.this.gcB.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.gcB.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0567a() { // from class: com.baidu.tieba.ala.liveroom.o.a.2
                        @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0567a
                        public void onConfirm() {
                            if (a.this.gcB != null && a.this.gcB.user_info != null) {
                                a.this.gcB.user_info.is_block = 1;
                                a.this.gcC.CC(a.this.gcB.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.gcB.user_info.getNameShow()));
                }
            } else if (view == this.gcx) {
                if (this.gcB != null && this.gcB.user_info != null) {
                    if (bFK()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0567a() { // from class: com.baidu.tieba.ala.liveroom.o.a.3
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0567a
                            public void onConfirm() {
                                if (a.this.gcB != null && a.this.gcB.user_info != null) {
                                    a.this.gcB.user_info.is_block = 0;
                                    a.this.gcC.CF(a.this.gcB.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.gcB.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0567a() { // from class: com.baidu.tieba.ala.liveroom.o.a.4
                        @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0567a
                        public void onConfirm() {
                            if (a.this.gcB != null && a.this.gcB.user_info != null) {
                                a.this.gcB.user_info.is_block = 2;
                                a.this.gcC.CD(a.this.gcB.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.gcB.user_info.getNameShow()));
                }
            } else if (view == this.gcy) {
                if (this.gcB != null && this.gcB.login_user_info != null) {
                    if (bFM()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0567a() { // from class: com.baidu.tieba.ala.liveroom.o.a.5
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0567a
                            public void onConfirm() {
                                if (a.this.gcB != null && a.this.gcB.login_user_info != null) {
                                    a.this.gcB.login_user_info.is_live_admin = 1;
                                    a.this.gcC.CG(a.this.gcB.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.gcB.user_info.getNameShow()));
                    } else if (bFN()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0567a() { // from class: com.baidu.tieba.ala.liveroom.o.a.6
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0567a
                            public void onConfirm() {
                                if (a.this.gcB != null && a.this.gcB.login_user_info != null) {
                                    a.this.gcB.login_user_info.is_live_admin = 0;
                                    a.this.gcC.CH(a.this.gcB.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.gcB.user_info.getNameShow()));
                    } else if (bFO()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0567a() { // from class: com.baidu.tieba.ala.liveroom.o.a.7
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0567a
                            public void onConfirm() {
                                if (a.this.gcB != null && a.this.gcB.login_user_info != null) {
                                    a.this.gcB.login_user_info.is_live_admin = 0;
                                    a.this.gcC.bFR();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.dhT) {
                this.gcC.onCancel();
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
        this.gcB = personUserData;
        this.aSw = z;
        this.aSx = str;
        if (bFP() || bFQ()) {
            rw(8);
            rx(8);
        } else if (bFK()) {
            rw(8);
            this.gcx.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (bFL()) {
            rw(0);
            this.gcw.setText(a.i.ala_person_relieve_forbidden_this);
            this.gcx.setText(a.i.ala_person_forbid_forever);
        } else {
            rw(0);
            this.gcw.setText(a.i.ala_person_forbid_this);
            this.gcx.setText(a.i.ala_person_forbid_forever);
        }
        if (bFJ()) {
            this.gcy.setVisibility(8);
            this.gcA.setVisibility(8);
        } else if (bFN()) {
            this.gcy.setText(a.i.ala_person_fire_admin);
        } else if (bFM()) {
            this.gcy.setText(a.i.ala_person_appoint_admin);
        } else if (bFP() && bFO()) {
            this.gcy.setText(a.i.ala_person_resign_admin);
        } else {
            this.gcy.setVisibility(8);
            this.gcA.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.gcC = bVar;
    }

    private boolean bFJ() {
        return (this.gcB == null || this.gcB.user_info == null || this.gcB.user_info.is_block <= 0) ? false : true;
    }

    private boolean bFK() {
        return (this.gcB == null || this.gcB.user_info == null || this.gcB.user_info.is_block != 2) ? false : true;
    }

    private boolean bFL() {
        return (this.gcB == null || this.gcB.user_info == null || this.gcB.user_info.is_block != 1) ? false : true;
    }

    private boolean bFM() {
        return this.gcB != null && this.gcB.user_info != null && this.aSw && this.gcB.user_info.is_live_admin == 0;
    }

    private boolean bFN() {
        return this.gcB != null && this.gcB.user_info != null && this.aSw && this.gcB.user_info.is_live_admin == 1;
    }

    private boolean bFO() {
        return (this.gcB == null || this.gcB.login_user_info == null || this.aSw || this.gcB.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean bFP() {
        return (this.gcB == null || this.gcB.user_info == null || TextUtils.isEmpty(this.aSx) || !this.aSx.equals(this.gcB.user_info.user_id)) ? false : true;
    }

    private boolean bFQ() {
        return (this.gcB == null || this.gcB.user_info == null || this.gcB.user_info.is_live_admin != 1) ? false : true;
    }

    private void rw(int i) {
        this.gcw.setVisibility(i);
        this.gcz.setVisibility(i);
    }

    private void rx(int i) {
        this.gcx.setVisibility(i);
        this.gcA.setVisibility(i);
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
