package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String arZ;
    private String asa;
    private String asb;
    private String asc;
    private String asf;
    private String asg;
    private String ash;
    private String asi;
    private String asj;
    private String ask;
    private int arD = 0;
    private int arE = 0;
    private int arF = 0;
    private int arG = 0;
    private int arH = 0;
    private int arI = 0;
    private int arJ = 0;
    private int arK = 0;
    private int arL = 0;
    private int arM = 0;
    private int arN = 0;
    private int arO = 0;
    private int arP = 0;
    private int arQ = 0;
    private int arR = 0;
    private int arS = 0;
    private int arT = 0;
    private int arU = 0;
    private int arV = 0;
    private int arW = 0;
    private boolean arX = true;
    private boolean arY = true;
    private HashMap<String, String> asd = new HashMap<>();
    private HashMap<String, String> ase = new HashMap<>();
    private String asl = null;
    private String asm = null;
    private List<b> asn = new ArrayList();
    private List<a> aso = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int asp;
        public int asq;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int asp;
        public int asq;
        public String asr;
        public String ass;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zN() {
        HashMap<String, String> Ad = Ad();
        Set<String> keySet = Ad.keySet();
        if (keySet.size() != 1) {
            eI(null);
        } else {
            eI(Ad.get(keySet.iterator().next()));
        }
    }

    public void zO() {
        HashMap<String, String> Aj = Aj();
        Set<String> keySet = Aj.keySet();
        if (keySet.size() != 1) {
            eO(null);
        } else {
            eO(Aj.get(keySet.iterator().next()));
        }
    }

    public int zP() {
        return this.arD;
    }

    public void dL(int i) {
        this.arD = i;
    }

    public int zQ() {
        return this.arG;
    }

    public void dM(int i) {
        this.arG = i;
    }

    public int zR() {
        return this.arH;
    }

    public int zS() {
        return this.arL;
    }

    public void dN(int i) {
        this.arL = i;
    }

    public int zT() {
        return this.arP;
    }

    public void dO(int i) {
        this.arP = i;
    }

    public int zU() {
        return this.arO;
    }

    public void dP(int i) {
        this.arO = i;
    }

    public int zV() {
        return this.arD;
    }

    public int zW() {
        return this.arF;
    }

    public void dQ(int i) {
        this.arF = i;
    }

    public boolean zX() {
        return this.arX;
    }

    public void bi(boolean z) {
        this.arX = z;
    }

    public String zY() {
        return this.arZ;
    }

    public void eH(String str) {
        this.arZ = str;
    }

    public String zZ() {
        return this.asf;
    }

    public void eI(String str) {
        this.asf = str;
    }

    public void eJ(String str) {
        this.asg = str;
    }

    public int Aa() {
        return this.arE;
    }

    public void dR(int i) {
        this.arE = i;
    }

    public void eK(String str) {
        this.ash = str;
    }

    public String Ab() {
        return this.asj;
    }

    public String Ac() {
        return this.ask;
    }

    public HashMap<String, String> Ad() {
        return this.asd;
    }

    public int Ae() {
        return this.arI;
    }

    public void dS(int i) {
        this.arI = i;
    }

    public int Af() {
        return this.arM;
    }

    public void dT(int i) {
        this.arM = i;
    }

    public int Ag() {
        return this.arQ;
    }

    public void dU(int i) {
        this.arQ = i;
    }

    public void eL(String str) {
        this.asa = str;
    }

    public void eM(String str) {
        this.asb = str;
    }

    public int Ah() {
        return this.arN;
    }

    public void dV(int i) {
        this.arN = i;
    }

    public String Ai() {
        return this.asc;
    }

    public void eN(String str) {
        this.asc = str;
    }

    public HashMap<String, String> Aj() {
        return this.ase;
    }

    public String Ak() {
        return this.asi;
    }

    public void eO(String str) {
        this.asi = str;
    }

    public int Al() {
        return this.arJ;
    }

    public int Am() {
        return this.arK;
    }

    public void dW(int i) {
        this.arJ = i;
    }

    public void dX(int i) {
        this.arK = i;
    }

    public void eP(String str) {
        this.asl = str;
    }

    public void eQ(String str) {
        this.asm = str;
    }

    public int An() {
        return this.arS;
    }

    public void dY(int i) {
        this.arS = i;
    }

    public int Ao() {
        return this.arT;
    }

    public void dZ(int i) {
        this.arT = i;
    }

    public int Ap() {
        return this.arU;
    }

    public void ea(int i) {
        this.arU = i;
    }

    public int Aq() {
        return this.arV;
    }

    public void eb(int i) {
        this.arV = i;
    }

    public List<b> Ar() {
        return this.asn;
    }

    public List<a> As() {
        return this.aso;
    }

    public int At() {
        return this.arW;
    }

    public void ec(int i) {
        this.arW = i;
    }
}
