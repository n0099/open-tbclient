package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ab f1405a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.f1405a = abVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar;
        int i2;
        int i3;
        EditText editText;
        EditText editText2;
        EditText editText3;
        Activity activity;
        EditText editText4;
        EditText editText5;
        EditText editText6;
        EditText editText7;
        EditText editText8;
        EditText editText9;
        EditText editText10;
        EditText editText11;
        if (i % 27 != 0 || i == 0) {
            mVar = this.f1405a.f;
            i2 = this.f1405a.c;
            i3 = this.f1405a.c;
            String a2 = mVar.a(((((i2 - 1) * 28) + i) - i3) + 1);
            if (a2 != null) {
                editText = this.f1405a.b;
                int selectionStart = editText.getSelectionStart();
                editText2 = this.f1405a.b;
                editText2.getText().insert(selectionStart, a2);
                return;
            }
            return;
        }
        editText3 = this.f1405a.b;
        if (editText3.getSelectionStart() > 0) {
            activity = this.f1405a.f1404a;
            ((ImageView) view).setImageBitmap(((BitmapDrawable) activity.getResources().getDrawable(R.drawable.but_face_close_n)).getBitmap());
            editText4 = this.f1405a.b;
            String obj = editText4.getText().toString();
            editText5 = this.f1405a.b;
            String substring = obj.substring(0, editText5.getSelectionStart());
            Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
            if (!matcher.find()) {
                editText6 = this.f1405a.b;
                Editable text = editText6.getText();
                editText7 = this.f1405a.b;
                editText8 = this.f1405a.b;
                text.delete(editText7.getSelectionStart() - 1, editText8.getSelectionStart());
                return;
            }
            int length = substring.length() - matcher.replaceFirst("").length();
            editText9 = this.f1405a.b;
            Editable text2 = editText9.getText();
            editText10 = this.f1405a.b;
            int selectionStart2 = editText10.getSelectionStart() - length;
            editText11 = this.f1405a.b;
            text2.delete(selectionStart2, editText11.getSelectionStart());
        }
    }
}
