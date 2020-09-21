package com.baidu.tieba.ala.liveroom.d;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.bk;
import com.baidu.live.data.n;
import com.baidu.live.data.u;
import com.baidu.live.q.e;
import com.baidu.live.q.f;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c {
    private AlaLastLiveroomInfo fAJ;
    private com.baidu.tieba.ala.liveroom.data.a gql;
    private bk gra;
    private boolean grh;
    private short gsb = 0;
    private com.baidu.live.liveroom.f.a gsc;
    private com.baidu.live.liveroom.a.c gsd;
    private String otherParams;

    public void d(short s) {
        if (this.gsc != null && (this.gsc instanceof b)) {
            this.gsc.cb(true);
            this.gsc = null;
        }
        if (this.gsc == null) {
            this.gsc = com.baidu.live.liveroom.f.c.LZ().Ma().b(s);
            if (this.gsc != null) {
                this.gsc.setActivity(this.gql.pageContext.getPageActivity());
                this.gsc.a(this.gsd);
                this.gsc.b(this.gql.gAv);
                if (this.gql.gAv.getParent() != null && (this.gql.gAv.getParent() instanceof ViewGroup)) {
                    this.gsc.p((ViewGroup) this.gql.gAv.getParent());
                }
                this.gsc.a(this.gql.gAt, this.gql.bhe);
                this.gsb = (short) 0;
                this.gql.gAy = false;
                this.gsc.init();
                return;
            }
            return;
        }
        this.gsc.b(this.gql.gAv);
        if (this.gql.gAv.getParent() != null && (this.gql.gAv.getParent() instanceof ViewGroup)) {
            this.gsc.p((ViewGroup) this.gql.gAv.getParent());
        }
        this.gsc.a(this.gql.gAt, this.gql.bhe);
    }

    public void e(short s) {
        if (1 == s) {
            if (this.gsc != null && !(this.gsc instanceof a)) {
                this.gsc.cb(true);
                this.gsc = null;
            }
            if (this.gsc == null) {
                a aVar = new a();
                this.gsb = (short) 0;
                aVar.a(this.gql);
                aVar.a(this.gsd);
                aVar.setActivity(this.gql.pageContext.getPageActivity());
                this.gql.gAy = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.gsc = aVar;
            }
            this.gsc.a(this.gql.gAt, this.gql.bhe);
        } else if (2 == s) {
            if (this.gsc != null && !(this.gsc instanceof d)) {
                this.gsc.cb(true);
                this.gsc = null;
            }
            if (this.gsc == null) {
                d dVar = new d();
                this.gsb = (short) 0;
                dVar.a(this.gql);
                dVar.a(this.gsd);
                dVar.setActivity(this.gql.pageContext.getPageActivity());
                this.gql.gAy = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.gsc = dVar;
            }
        }
        if (this.gsc instanceof b) {
            b bVar = (b) this.gsc;
            bVar.bPc();
            bVar.lL(this.grh);
            bVar.a(this.gra);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.q.d dVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bk bkVar) {
        if (this.gql == null) {
            this.gql = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.gql.pageContext = tbPageContext;
        this.gql.gAv = alaLiveView;
        this.gql.bhe = fVar;
        this.gql.gAt = eVar;
        this.gql.gAu = dVar;
        this.gql.fromType = str;
        this.gql.enterTime = j;
        this.gql.gAw = z;
        this.gql.gAz = arrayList;
        this.gql.gAA = false;
        this.gra = bkVar;
    }

    public void lL(boolean z) {
        this.grh = z;
        if (this.gsc != null && (this.gsc instanceof b)) {
            ((b) this.gsc).lL(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.gsd = cVar;
        if (this.gsc != null) {
            this.gsc.a(this.gsd);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.gql != null) {
            this.gql.gAt = alaLiveRoomBlurPageLayout;
        }
    }

    public void lP(boolean z) {
        if (this.gsb != 1) {
            if (this.gql != null) {
                this.gql.gAy = false;
            }
            try {
                if (this.gsc != null) {
                    if (this.gql != null) {
                        if (this.gsc instanceof d) {
                            ((d) this.gsc).b(this.fAJ);
                        } else if (this.gsc instanceof a) {
                            ((a) this.gsc).b(this.fAJ);
                        }
                        this.gsc.n(this.gql.gAu.Fq());
                    }
                    if ((this.gsc instanceof d) && z) {
                        ((d) this.gsc).lR(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gsb = (short) 1;
        }
    }

    public void dH(int i) {
        if (this.gql != null) {
            this.gql.gAA = true;
        }
        if (this.gsc != null) {
            this.gsc.dH(i);
        }
    }

    public void bPW() {
        if (this.gql != null) {
            this.gql.gAx = true;
        }
    }

    public void a(u uVar) {
        if (this.gsc != null) {
            this.gsc.l(uVar);
        }
    }

    public void c(n nVar) {
        if (this.gsc != null) {
            this.gsc.b(nVar);
        }
    }

    public void lQ(boolean z) {
        if (this.gsb != 3) {
            try {
                if (this.gql != null) {
                    this.gql.gAy = false;
                }
                if (this.gsc != null) {
                    this.gsc.cd(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gsb = (short) 3;
        }
    }

    public void bPX() {
        if (this.gsb != 4) {
            try {
                if (this.gql != null) {
                    this.gql.gAy = true;
                    if (this.gsc != null) {
                        this.gsc.o(this.gql.gAu.Fq());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gra = null;
            this.gsb = (short) 4;
        }
    }

    public boolean bPY() {
        if (this.gsc == null || !(this.gsc instanceof b)) {
            return false;
        }
        return ((b) this.gsc).bOU();
    }

    public boolean bPZ() {
        if (this.gsc != null && (this.gsc instanceof b) && ((b) this.gsc).grq) {
            return false;
        }
        if (this.gsb != 5) {
            if (this.gql != null) {
                this.gql.gAy = false;
            }
            try {
                if (this.gsc != null) {
                    boolean LX = this.gsc.LX();
                    if (LX && (this.gsc instanceof b)) {
                        ((b) this.gsc).grp = true;
                    }
                    return LX;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gsb = (short) 5;
        }
        if (this.gsc != null && (this.gsc instanceof b)) {
            ((b) this.gsc).grp = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.gsc != null) {
            this.gsc.cb(false);
        }
    }

    public void enterBackground() {
        if (this.gsc != null) {
            this.gsc.onPause();
        }
    }

    public void enterForeground() {
        if (this.gsc != null) {
            this.gsc.onResume();
        }
    }

    public void bQa() {
        if (this.gsc != null) {
            this.gsc.onStop();
        }
    }

    public void bQb() {
        if (this.gsc != null) {
            this.gsc.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gsc != null) {
            this.gsc.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gsc != null) {
            this.gsc.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gsc != null) {
            this.gsc.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bPS() {
        return this.gql;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bQc() {
        return this.gsc;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gsc != null) {
            return this.gsc.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.fAJ = alaLastLiveroomInfo;
    }
}
