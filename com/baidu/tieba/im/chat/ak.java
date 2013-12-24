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
public class ak implements AdapterView.OnItemClickListener {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.a = ajVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        q qVar;
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
            qVar = this.a.f;
            i2 = this.a.c;
            i3 = this.a.c;
            String a = qVar.a(((((i2 - 1) * 28) + i) - i3) + 1);
            if (a != null) {
                editText = this.a.b;
                int selectionStart = editText.getSelectionStart();
                editText2 = this.a.b;
                editText2.getText().insert(selectionStart, a);
                return;
            }
            return;
        }
        editText3 = this.a.b;
        if (editText3.getSelectionStart() > 0) {
            activity = this.a.a;
            ((ImageView) view).setImageBitmap(((BitmapDrawable) activity.getResources().getDrawable(R.drawable.but_face_close_n)).getBitmap());
            editText4 = this.a.b;
            String obj = editText4.getText().toString();
            editText5 = this.a.b;
            String substring = obj.substring(0, editText5.getSelectionStart());
            Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
            if (!matcher.find()) {
                editText6 = this.a.b;
                Editable text = editText6.getText();
                editText7 = this.a.b;
                editText8 = this.a.b;
                text.delete(editText7.getSelectionStart() - 1, editText8.getSelectionStart());
                return;
            }
            int length = substring.length() - matcher.replaceFirst("").length();
            editText9 = this.a.b;
            Editable text2 = editText9.getText();
            editText10 = this.a.b;
            int selectionStart2 = editText10.getSelectionStart() - length;
            editText11 = this.a.b;
            text2.delete(selectionStart2, editText11.getSelectionStart());
        }
    }
}
